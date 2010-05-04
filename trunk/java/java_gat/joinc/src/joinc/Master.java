package joinc;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.gridlab.gat.GAT;
import org.gridlab.gat.GATContext;
import org.gridlab.gat.GATInvocationException;
import org.gridlab.gat.io.File;

import org.gridlab.gat.resources.HardwareResourceDescription;
import org.gridlab.gat.resources.Job;
import org.gridlab.gat.resources.JobDescription;
import org.gridlab.gat.resources.ResourceBroker;
import org.gridlab.gat.resources.ResourceDescription;
import org.gridlab.gat.resources.SoftwareDescription;

import org.gridlab.gat.GATObjectCreationException;
import org.gridlab.gat.URI;
import org.gridlab.gat.security.PasswordSecurityContext;

import org.gridlab.gat.monitoring.Metric;
import org.gridlab.gat.monitoring.MetricDefinition;
import org.gridlab.gat.monitoring.MetricListener;
import org.gridlab.gat.monitoring.MetricValue;

import org.gridlab.gat.Preferences;


/**
 * This is the main class of the JOINC library.
 * 
 * It mainly consists of abstract methods, which will be implemented by 
 * application. Since these methods are the interface to the outside world, 
 * they may NOT be changed! For an example of how they are used, see the 
 * applications.      
 *  
 * @author Jason Maassen, S. Koulouzis
 * @version 2.0.1 Apr 30, 2008
 * @since 1.0
 * 
 */
public abstract class Master  implements MetricListener{
    /** The GAT context*/
    private GATContext context;
     /**  Software Description of the jar */
    private SoftwareDescription sd;
    /**  Hardware Resources obtained from either a broker or the workerNodes file*/
    private ResourceDescription[] hardwareResources;
    /**  total tasks */
    private java.util.ArrayList totalTasks;
    /**  current task processed */
    private Task currentTask;
     /**  The Resource Broker */
    private ResourceBroker broker;
    /**  The classpath of the worker jar*/
    private String classpath="";
    /**  The Job Description*/
    private JobDescription jd;
    /**  Total jobs*/
    private java.util.ArrayList jobs;
    /**Output Files given by the implementation */
    private File[] appOutputFiles;
    /**Nesseary files for the worker*/
    private java.util.ArrayList preStageFiles;
    /** The current job runing*/
    private Job currentJob;
    
//    private static final long GB = 1073741824;
    /**If no resources are found this is set to false and the application exits */
    private boolean foundResources=false;
    /**Times to re-submit a job */
    private static int tolerance = 20;
    private Preferences prefs;
    /**true if all jobes are done */
    private boolean done = false;
    private static int tasksDone=0;
    
    private java.util.ArrayList jobsNotSubmited;
    private java.util.ArrayList tasksNotSubmited;
    private java.util.ArrayList tasksSubmited;
    private int jobsSubmitied = 0;
    
//    private long[] jobINITIAL;
//    private long[] jobON_HOLD;
//    private long[] jobPOST_STAGING;
//    private long[] jobPRE_STAGING;
    /** Execution times of all the tasks generated*/
    private long[] jobRUNNING;
//    private long[] jobSCHEDULED;
//    private long[] jobSTOPPED;
            
    /**
     * Returns a task that can be run on the grid.
     * (This method will be implemented by the application).
     * 
     * @return a task to run on the grid.
     */
    public abstract Task getTask(); 
    
    /**
     * This method will be implemented by the application. 
     * It must be called by your code after a task is done 
     * to notify the application of this fact.
     *
     * @param task The task that has finished.
     */
    public abstract void taskDone(Task task); 
        
    /**
     * Returns the total number of tasks that need to be run.
     * (This method will be implemented by the application).
     *  
     * @return number of tasks that will be produced.
     */
    public abstract int totalTasks();
    
    /**
     * Returns the maximum number of workers that may be used.
     * (This method will be implemented by the application). 
     *      
     * @return the maximum number of workers you may use.
     */
    public abstract int maximumWorkers(); 
        
    /**
     * If there is nothing else to do, you may call this method 
     * to allow the application to do some work.
     * (This method will be implemented by the application).
     */
    public abstract void idle();  
    
    /**
     * This is the method you have to implement. By using the
     * abstract methods above you can get information and jobs
     * from the application. Do whatever you need to do here
     * to run these jobs on 'the grid'. Don't forget to notify
     * the application every time a job has finished.
     * 
     * Keep in mind that machines or jobs may fail, so you may
     * need to restart them sometimes. Also, you should not use
     * more workers than what 'maximumWorkers()' returns.
     * 
     * Enjoy! 
     */
    public void start() { 
        // this is your playground  
        try {
            initGat();            
            jobs = new java.util.ArrayList(totalTasks());
            jobsNotSubmited = new java.util.ArrayList(totalTasks());
            totalTasks = new java.util.ArrayList(totalTasks());
            tasksNotSubmited = new java.util.ArrayList(totalTasks());
            tasksSubmited  = new java.util.ArrayList(totalTasks());
            
            Job currentJob=null;
            for(int i = 0; i<totalTasks();i++ ){
                totalTasks.add(getTask());
            }
//            jobINITIAL= new long[totalTasks()];
//            jobON_HOLD= new long[totalTasks()];
//            jobPOST_STAGING= new long[totalTasks()];
//            jobPRE_STAGING= new long[totalTasks()];
            jobRUNNING= new long[totalTasks()];
//            jobSCHEDULED= new long[totalTasks()];
//            jobSTOPPED = new long[totalTasks()];

            
            initWorkerNodes(estimateReuriments());
            Job job=null;
            
            for(int i = 0; i<totalTasks.size();i++ ){
                
                currentTask = (Task)totalTasks.get(i);
                initPreStageFiles();
                initOuputFiles();
                sd = initSoftwareDescription();
                                
                jd = new JobDescription(sd);
                                   
                if(jobsSubmitied < maximumWorkers()){
                    currentJob = null;
                    currentJob =  broker.submitJob(jd);
                    jobsSubmitied++;
                    jobRUNNING[currentTask.taskNumber] = System.currentTimeMillis();
                    currentJob = addMetricDefinitionToJob(currentJob);
                    jobs.add(currentJob);
                    tasksSubmited.add(currentTask);
                }else{
                    jobsNotSubmited.add(jd);
                    tasksNotSubmited.add(currentTask);
                }
            }
            monitorJobs(jobs,tasksSubmited);
            
           
            long average=0;
            for(int i=0;i<totalTasks();i++){
//                System.out.println(" Job"+i);
//
//                System.out.println("Total: "+jobRUNNING[i]/1000.0);
                average = average + jobRUNNING[i];
////                System.out.println("jobSCHEDULED: "+jobSCHEDULED[i]/1000.0);
////                System.out.println("jobPOST_STAGING: "+jobPOST_STAGING[i]/1000.0);
            }
            average = average/(long)totalTasks();
            System.out.println("Average time per job "+average/1000.0);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            GAT.end();
        }
    }          
    
    /**
     * Initializes GATContext, loads passwords if they can be found, and instaniates a Resource Broker.
     */
    private void initGat() throws FileNotFoundException,IOException,GATObjectCreationException {
        context = new GATContext();
        prefs = new Preferences();   
//        prefs.put("ResourceBroker.jobmanagerContact", "fs0.das3.cs.vu.nl");      
        prefs.put("ResourceBroker.adaptor.name", "DAS");
        
        //use KeyStore to get passwords. This is a simple case were pwd is in a text file 
        java.io.File pwdFile = new java.io.File("pwd");
        if(pwdFile.exists()){
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(pwdFile));
            String[] userPass = in.readLine().split(",");
            PasswordSecurityContext pwd = new PasswordSecurityContext(userPass[0],userPass[1]);
            context.addSecurityContext(pwd);
            in.close();
        }
        broker = GAT.createResourceBroker(context,prefs);
    }
    
    /**
     * Try to make an estimate of the job requirements. Its easy is to ask for cpus. 
     * The  hard part is estimating the size of the generated output files
     */
    private java.util.Hashtable estimateReuriments(){
        java.util.Hashtable hardwareAttributes = new java.util.Hashtable(); 
        hardwareAttributes.put("cpu.count",String.valueOf(maximumWorkers()));
//        hardwareAttributes.put("machine.node","node001");
        //complicated, just get the nodes;
        long diskRequrements=0;   
        
        return hardwareAttributes;
    }
    
    /**
     * In the absence of a resource manager the a way of obtatining computational nodes, is to get them from a file. 
     */
    private void initWorkerNodes(java.util.Hashtable hardwareAttributes) throws FileNotFoundException,IOException {
        hardwareResources = null;
        HardwareResourceDescription hDescription = new HardwareResourceDescription(hardwareAttributes);
//        try {
//            java.util.List hResources =  broker.findResources(hDescription);
//            if(hResources!=null && !hResources.isEmpty()){
//                hardwareResources = new HardwareResourceDescription[hResources.size()];
//                for(int i=0;i<hardwareResources.length;i++){
//                   hardwareResources[i] =  (ResourceDescription)hResources.get(i);
//                }
//            }
//            foundResources = true;
//        } catch (GATInvocationException ex) {
//            foundResources = false;
//            //ex.printStackTrace(); not imlemented
//        }
        
//        if(!foundResources){
//            java.io.File nodesFile = new java.io.File("workerNodes");
//            if(nodesFile.exists()){
//                java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(nodesFile));
//                java.util.ArrayList nodes = new java.util.ArrayList();
//                String aNode=null;
//                while( (aNode = in.readLine())!=null ){
//                    if(!aNode.startsWith("#")){
//                        nodes.add(aNode);   
//                    }
//                }
//                in.close();       
//                hardwareResources = new HardwareResourceDescription[nodes.size()];
//                for(int i=0;i<hardwareResources.length;i++){
//                    hardwareAttributes = new java.util.Hashtable(); 
//                    hardwareAttributes.put("machine.node", (String)nodes.get(i));
//                    hardwareResources[i] = new HardwareResourceDescription(hardwareAttributes);
//                }
//                foundResources = true;
//            }else{
//                foundResources = false;
//            }
//        }
//        if(foundResources){
//            setHardwareResources(hardwareResources);
//        }else{
            hardwareResources = new HardwareResourceDescription[1];
            hardwareAttributes = new java.util.Hashtable(); 
            hardwareResources[0] = new HardwareResourceDescription(hardwareAttributes);
            setHardwareResources(hardwareResources);
//        }
    }
    
    /**
     * Initializes all the necessary prestage files, making sure every input file exists. 
     * Additionally the classpath for the worker is initialized as well, reading the jar files  
     */
    private void initPreStageFiles()throws GATObjectCreationException, URISyntaxException,GATInvocationException{
        preStageFiles = new java.util.ArrayList();        
        File f;
        for(int i=0;i<currentTask.inputFiles.length;i++){
            f = GAT.createFile(context, prefs ,new URI("any:///"+currentTask.inputFiles[i]));
            if(f.exists()){
                preStageFiles.add(f);
            }
        }
        for(int i=0;i<currentTask.jars.length;i++){                
            f = GAT.createFile(context, prefs ,new URI("any:///"+currentTask.jars[i]));
                preStageFiles.add(f);
                classpath = classpath + f.getName()+":";
        }
    }    
    /**
     * Create output files, making sure a null argument didn't slip through   
     */
    private void initOuputFiles() throws GATObjectCreationException, URISyntaxException,GATInvocationException,IOException{
        String aNode=null;
        appOutputFiles = new File[currentTask.outputFiles.length];
        for(int i=0;i<currentTask.outputFiles.length;i++){
            if(currentTask.outputFiles[i]!=null){
                appOutputFiles[i] =  GAT.createFile(context,prefs ,new URI("any:///"+currentTask.outputFiles[i]));
                debugMessage("Creating file: "+currentTask.outputFiles[i]);
            }
        }
    }  
        
    /**
     * Now it's time for the job.... Set all the pre and post stage files, classpaths, std in out err, the lot
     */
    private SoftwareDescription initSoftwareDescription() throws GATObjectCreationException,URISyntaxException,GATInvocationException {
        SoftwareDescription sd = new SoftwareDescription();
        File outFile;
        File errFile;
        File src;
        File dest;
        java.util.HashMap attributes = new java.util.HashMap();
        
        if(currentTask.stdoutFile != null){
            outFile = GAT.createFile(context,prefs, new URI("any:///" + currentTask.stdoutFile));
            sd.setStdout(outFile);
            debugMessage("Stdout :"+"any:///"+currentTask.stdoutFile);
        }else{
            outFile = GAT.createFile(context,prefs,new URI("any:///std.out"));
            sd.setStdout(outFile);
            debugMessage("Stdout :"+"any:///std.out");
        }
        if(currentTask.stdinFile!=null){
            File inFile = GAT.createFile(context, prefs ,new URI("any:///"+currentTask.stdinFile));
            sd.setStdin(inFile);
            debugMessage("Stin :"+"any:///"+currentTask.stdinFile);
        }else{
            
        }
        if(currentTask.stderrFile!=null){
            errFile = GAT.createFile(context,prefs, new URI("any:///"+currentTask.stderrFile));
            sd.setStderr(errFile);
            debugMessage("Stdout :"+"any:///"+currentTask.stderrFile);
        }else{
            errFile = GAT.createFile(context,prefs,new URI("any:///std.err"));
            sd.setStderr(errFile);
        }

        sd.setPostStaged(getAppOutputFiles());
                       
        File f[] = new File[preStageFiles.size()];
        f = (File[]) preStageFiles.toArray(f);
                
        sd.setPreStaged(f);
               
        sd.setLocation(new URI("java:"+currentTask.className));

        sd.setArguments(currentTask.parameters);
                        
//        attributes.put("hostCount", new Integer(1)); 
        debugMessage("Attributes: hostCount, " + "1");
        attributes.put("java.home", new URI(System.getProperty("java.home")));
        debugMessage("Attributes: java.home, "+ System.getProperty("java.home"));
        attributes.put("java.class.path", classpath);
        debugMessage("Attributes: java.class.path, "+classpath);
        attributes.put("java.classpath", classpath); 
        attributes.put("jobType", "single"); 
          
        sd.setAttributes(attributes);
        
        return sd;
    }
     
    /**
      After the job is submitted this method blocks till all the jobs are or done 
     * or failed. This method will also resubmit failed jobs up to <code>tolerance</code> times. 
     * After the tolerance of resubmitting is expired one last try is made to chance 
     * resource. If that also fails there is nothing more to do  
     * @param jobs total jobs creted
     * @param tasks total tasks 
     */          
    private void monitorJobs(java.util.AbstractList jobs, java.util.AbstractList tasks) throws GATInvocationException,InterruptedException{  
        boolean done = false;
        
        int jobState;
        int failedAttempts=0;
        currentJob = (Job)jobs.get(0);
        int allocatedResources=0;
        debugMessage("current Job "+currentJob.getJobID()+" job state = " + currentJob.getInfo());
        synchronized (this) {
            
            while (!done ) {
            for(int i=0;i<jobs.size();i++){
                currentJob = (Job)jobs.get(i);
                currentTask = (Task)tasks.get(i); 
                jobState = currentJob.getState();
                debugMessage("current Job "+currentJob.getJobID()+" current Job state = " + currentJob.getInfo());
                if((jobState == Job.STOPPED) || (jobState == Job.SUBMISSION_ERROR)){
                    
                    if( currentJob.getInfo().get("postStageError")!=null && failedAttempts <= getTolerance()) {                        
                        debugMessage("Job failed. Attemt num "+failedAttempts+". Resubmiting..");
                        System.out.println("Job "+currentTask.taskNumber+" failed. Attemt num "+failedAttempts+". Resubmiting..");
                        jobs.remove(currentJob);
                            try {
                                currentJob = reSubmitTask(currentJob.getJobDescription());
                                jobs.add(currentJob);
                                failedAttempts++;
                            } catch (GATObjectCreationException ex) {
                                ex.printStackTrace();
                            } catch (GATInvocationException ex) {
                                ex.printStackTrace();
                            } catch (URISyntaxException ex) {
                                ex.printStackTrace();
                            }
                        
                    }else if( currentJob.getInfo().get("postStageError")==null){
                        taskDone(currentTask);
                        jobRUNNING[currentTask.taskNumber] = System.currentTimeMillis() - jobRUNNING[currentTask.taskNumber];
                        jobs.remove(currentJob);
                        tasks.remove(currentTask);
                        
                        if(!jobsNotSubmited.isEmpty()){
                                try {
                                    currentJob = reSubmitTask((JobDescription)jobsNotSubmited.remove(0));
                                    jobs.add(currentJob);
                                    currentTask = (Task)tasksNotSubmited.remove(0);
                                    jobRUNNING[currentTask.taskNumber] = System.currentTimeMillis();
                                    tasks.add(currentTask);
                                } catch (GATInvocationException ex) {
                                    ex.printStackTrace();
                                } catch (GATObjectCreationException ex) {
                                    ex.printStackTrace();
                                } catch (URISyntaxException ex) {
                                    ex.printStackTrace();
                                }                            
                        }
                        
                        if(jobs.isEmpty()){
                            done = true;
                        }
                        failedAttempts=0;
                        break;
                    }
                    //one last try. Change resource
                    if(failedAttempts > getTolerance()){
                        debugMessage("Job failed. Attemt num "+failedAttempts+". Resubmiting to new resource");
                        jobs.remove(currentJob);
                            try {
                                reSubmitTask(currentJob.getJobDescription());
                            } catch (GATObjectCreationException ex) {
                                ex.printStackTrace();
                            } catch (GATInvocationException ex) {
                                ex.printStackTrace();
                            } catch (URISyntaxException ex) {
                                ex.printStackTrace();
                            }
                        jobs.add(currentJob);
                        failedAttempts++;
                    }
                    
                }
                idle();
                wait();
            }
           }
        }
    }
           
    /** recreated a job from a <code>JobDescription</code> 
     *  @return job
     */
    private Job reSubmitTask(JobDescription jobd) throws GATInvocationException,GATObjectCreationException,URISyntaxException{
        currentJob = null;
        currentJob =  broker.submitJob(jobd);
        return addMetricDefinitionToJob(currentJob);
    }
    
    /** 
     * @retuns hardwareResources
     */
    public ResourceDescription[] getHardwareResources() {
        return hardwareResources;
    }

    /**
     *@param hardwareResources
     */
    public void setHardwareResources(ResourceDescription[] hardwareResources) {
        this.hardwareResources = hardwareResources;
    }
    
    /**
     *@param mess
     **/
    private void debugMessage(String mess){
        if(System.getProperty("joinc.debug")!=null && System.getProperty("joinc.debug").equals("true")){
            System.out.println( mess );                        
        }
    }

    /**
     *@return broker
     */
    public ResourceBroker getBroker() {
        return broker;
    }

  
    /**
     *@return jd
     */
    public JobDescription getJd() {
        return jd;
    }

    /**
     *@param jd
     */       
    public void setJd(JobDescription jd) {
        this.jd = jd;
    }

    /**
     * @return appOutputFiles
     */
    public File[] getAppOutputFiles() {
        return appOutputFiles;
    }

    /**
     * adds job status metric on a job
     *
     * @param job
     *
     * @return job
     */
    private Job addMetricDefinitionToJob(Job job) throws GATInvocationException{
        MetricDefinition md;
        md = job.getMetricDefinitionByName("job.status");
                                                
        for(int k=0;k<job.getMetricDefinitions().size();k++){
            debugMessage("job MetricDefinitions: "+ job.getMetricDefinitions().get(k));
        }

        Metric m = md.createMetric(null);

        job.addMetricListener(this, m);
        return job;
    }
    
    /**
     * On a change of state in a job this notifys all sleeping threads
     *
     * @param val
     */
    public synchronized void processMetricEvent(MetricValue val) {
        String state = (String) val.getValue();
        notifyAll();
    }

    /**
     *@return tolerance
     */
    public static int getTolerance() {
        return tolerance;
    }

    /**
     *@param aTolerance
     */
    public static void setTolerance(int aTolerance) {
        tolerance = aTolerance;
    }
    
}
