package broker.das;



import adaptive.service.*;
import adaptive.beans.*;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Iterator;
import javax.xml.rpc.ServiceException;

import org.gridlab.gat.GATContext;
import org.gridlab.gat.GATInvocationException;
import org.gridlab.gat.GATObjectCreationException;
import org.gridlab.gat.Preferences;
import org.gridlab.gat.resources.Job;
import org.gridlab.gat.resources.JobDescription;

import org.gridlab.gat.resources.cpi.globus.GlobusResourceBrokerAdaptor;

/**
 * <description> 
 * This is a resoutce broker, for the DAS-3 cluster. It uses a scoring system, to 
 * select the most suitable site. 
 * </description>
 *
 * @author jason, S. Koulouzis
 */
public class DASResourceBrokerAdaptor extends GlobusResourceBrokerAdaptor {
    
    private static AdaptiveInterface delphoi;
    private static Queue[] queues;
    private static Calendar prevCall;
    private static Calendar currentCall;
    private int siteIndex =-1;
    private long prestageSize;
    private String site;   
    
    /**
     * Starts and secures connection, the details of securing the connection
     * depend on the underlying protocol.
     *
     * @param gatContext
     * @param preferences
     * @throws  GATObjectCreationException
     */
    public DASResourceBrokerAdaptor(GATContext gatContext, Preferences preferences)
    throws GATObjectCreationException {
        
        super(gatContext, preferences);
        
        try{
            delphoi = new AdaptiveInterfaceServiceLocator().getAdaptive();
            prevCall = Calendar.getInstance();
            site = null;
        }catch(ServiceException ex){
            ex.printStackTrace();
        }
    }
    
    
    
    public Job submitJob(JobDescription description) throws GATInvocationException {
        try{
            currentCall = Calendar.getInstance();
            int min1 = prevCall.get(Calendar.MINUTE)+(prevCall.get(Calendar.HOUR_OF_DAY)*60);
            int min2 = currentCall.get(Calendar.MINUTE)+(currentCall.get(Calendar.HOUR_OF_DAY)*60);
            String prfSite = (String)preferences.get("ResourceBroker.jobmanagerContat");
            if(prfSite!=null){
                site = prfSite;
            }else {
                if((min2-min1)>=1 || siteIndex==-1){
                    prestageSize=0;
                    Iterator it = description.getSoftwareDescription().getPreStaged().keySet().iterator();
                    while(it.hasNext()){
                        Object obj = it.next();
                        if(obj instanceof org.gridlab.gat.io.File){
                            org.gridlab.gat.io.File f = (org.gridlab.gat.io.File)obj;
                            if(f.exists()){
                                prestageSize = prestageSize + f.length();
                            }
                        }
                    }
                    siteIndex = getBestSiteIndex();
                    site = queues[siteIndex].getHostname();
                    prevCall = currentCall;
                }
            }
            
            
            //code for testing------------
            File f = new File("sites");
            if( f.exists()){
                try {
                    java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(f));
                    site = in.readLine();
                    preferences.put("ResourceBroker.jobmanagerContact", site);
                    in.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            //-------------
            System.out.println("Site choosen : "+site);
            preferences.put("ResourceBroker.jobmanagerContact",site );
            
        }catch(RemoteException ex){
            //ex.printStackTrace();
            if(site==null){
                site = "fs0.das3.cs.vu.nl";
            }
            preferences.put("ResourceBroker.jobmanagerContact", site);
            System.err.println("There seems to be no one in Delphoi..Submitting job to:"+site);
        }
        
        return super.submitJob(description);
    }
    
    
    private int getBestSiteIndex()throws RemoteException{
        
        queues = delphoi.getQueues();
        double[] score = new double[queues.length];
        double[] loadBalance = new double[queues.length];
        double[] waitTime = new double[queues.length];
        double[] waitJobs = new double[queues.length];
        double[] nodes = new double[queues.length];
        double[] prestageTime = new double[queues.length];
        int index = -1;
        boolean isInDas = isDasSite();
        System.out.println();
        
        for(int i=0;i<queues.length;i++){
            //give some waight to wait times
            waitTime[i] = delphoi.getQueueInfo(queues[i],30,null,null).getAvgJobWaitingTime();
            score[i] = score[i] - (100 * waitTime[i]);
            waitJobs[i] = delphoi.getQueueInfo(queues[i],30,null,null).getAvgWaitingJobs();
            score[i] = score[i] - (100 * waitJobs[i]);
            score[i] = score[i] + delphoi.getQueueConf(queues[i]).getMaxJobs();
            nodes[i] = delphoi.getQueueConf(queues[i]).getNodes();
            score[i] = score[i] + (0.08 * nodes[i]);
            score[i] = score[i] + delphoi.getQueueConf(queues[i]).getMaxMem();
            score[i] = score[i] + delphoi.getQueueConf(queues[i]).getCpus();
            //            delphoi.getQueueConf(queues[i]).getCpuTime()
            double avgFreeNodes = delphoi.getResourceUtilization(queues[i], null,null).getAvgFreeNodes();
            score[i] = score[i] + (0.5 * avgFreeNodes);
            loadBalance[i] = (avgFreeNodes/nodes[i]);
            score[i] = score[i] + (100 * loadBalance[i]);
            //important file transfer.....
            if(isInDas&&!getHostName().equalsIgnoreCase(queues[i].getHostname())){
                prestageTime[i] = delphoi.estimateTransferTime(false,getHostName(),queues[i].getHostname(),prestageSize,"gridftp",currentCall);
                score[i] = score[i] - (100 * prestageTime[i]);
            }else if(!isInDas){
                prestageTime[i] = estimateTransferTime(queues[i].getHostname(), prestageSize);
                score[i] = score[i] - (10 * prestageTime[i]);
            }
            
        }
//        MetricDescription[] metricDescriptions = delphoi.knownMetrics(queues[0].getHostname());
//        Calendar aBitLater = (Calendar)currentCall.clone();
//        aBitLater.add(Calendar.MINUTE,5);
//        DoubleMeasurement[][][] measure=null;
//        for(int i=0;i<metricDescriptions.length;i++){
//            System.out.println("tName "+metricDescriptions[i].getName());
//             measure = delphoi.estimateNetworkMetricMatrix(delphoi.getActiveSites(),metricDescriptions[i].getName(),"max",currentCall,aBitLater);
//             System.out.println("measure "+measure);
//        }
        
        double max = -Double.MAX_VALUE;
        for(int i=0;i<score.length;i++){
            if(score[i] > max ){
                index = i;
                max = score[i];
            }
            System.out.println("Site: "+queues[i].getHostname() +" \n \t score: \t"+score[i]+"\n \t LoadBalance: \t"+loadBalance[i]+"\n \t waitTime: \t"+waitTime[i]+"\n \t waitJobs: \t"+waitJobs[i]+"\n \t prestageTime: \t"+prestageTime[i]);
        }
        
        return index;
        
    }
    
    private static String getHostName(){
        String hostname=null;
        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostname;
    }
    
    private static boolean isDasSite(){
        for(int i=0;i<queues.length;i++){
            if(queues[i].getHostname().equalsIgnoreCase(getHostName())){
                return true;
            }
        }
        return false;
    }
    
    
    
    private static double estimateTransferTime(String destinationHostName, long dataSize){
        //when passing arguments makes it exit with code 2
        String pingCmd = "ping " + destinationHostName;
        if(System.getProperty("os.name").equalsIgnoreCase("Linux")){
            try {
                Runtime r = Runtime.getRuntime();
                Process p = r.exec(pingCmd);
                java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
                String inputLine;
                int count=0;
                while ((inputLine = in.readLine()) != null) {
                    count++;
                    if(count>=5){
                        p.destroy();
                        break;
                    }
                }
                in.close();
                String[] results = inputLine.split(" ");
                results = results[results.length-2].split("=");
                double time = Double.parseDouble(results[results.length-1])/1000.0;
                time = ((dataSize*time)/64.0);
                return time/2.0;
                
            }//try
            catch (java.io.IOException ex) {
                ex.printStackTrace();
            }
        }
        
        return -1;
    }
    
}

