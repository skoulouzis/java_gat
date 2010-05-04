/*
 * Main.java
 *
 * Created on June 21, 2008, 7:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Tests;

import adaptive.beans.Queue;
import adaptive.service.AdaptiveInterface;
import adaptive.service.AdaptiveInterfaceServiceLocator;
import java.rmi.RemoteException;

/**
 *
 * @author alogo
 */
public class Main {
    AdaptiveInterface delphoi;
    Queue[] queues;
    
    
    /** Creates a new instance of Main */
    public Main() {
        try {
            delphoi = new AdaptiveInterfaceServiceLocator().getAdaptive();
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        Main m = new Main();
        try {
            System.out.println("Classpath: "+System.getProperty("java.class.path"));
            m.queues = m.delphoi.getQueues();
            for(int i=0;i<m.queues.length;i++){
                System.out.println("Hostname : "+m.queues[i].getHostname());
                System.out.println("    Jobmanager: "+m.queues[i].getJobmanager());
                System.out.println("    QueueName: "+m.queues[i].getQueueName());
            }
            System.out.println();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
         
    }
    
}
