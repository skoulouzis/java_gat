package applications.sim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import joinc.Master;
import joinc.Task;

/**
 * Example JOINC master application designed to test if the following features 
 * of JOINC:
 * 
 *    - jobs submission
 *    - input file stage in
 *    - output file stage out
 *    - fault-tolerance      
 *  
 * This application generates 'sim' jobs which read a simple input file, sleep 
 * for a while, then produce a simple output file. A command-line parameter 
 * determines the chance that the job will crash. 
 *  
 * @author Jason Maassen
 * @version 2.0 Feb 8, 2006
 * @since 1.0
 * 
 */
public class SIMMaster extends Master {
    
    // The input file for the workers.
    private final String inFile;
    
    // The jar file containing the workers.
    private final String workerJar;
    
    // The maximum number of workers allowed 
    // to be used simultaneously.
    private final int maxWorkers;
    
    // The time each task should take (in seconds). 
    private final int taskTime;
    
    // The total number of tasks to produce
    private final int totalTasks;
    
    // The chance a task crashes (0.0 ... 1.0) 
    private final double crashChance;
    
    // The number of tasks that are finished.
    private int tasksFinished = 0;    
    
    // The next task that will be produced. 
    private int nextTaskNumber = 0;
    
    // Start time of the master application.
    private long startTime;
        
    // Number of tasks failed (e.g., output not found/unreadable/incomplete)
    private int tasksFailed;
    
    // Decription of failed tasks
    private ArrayList taskErrors = new ArrayList();
        
    // The total time spend by the workers
    private double totalWorkerTime = 0.0;
    
    // The last status line printed
    private int lastFinishedPrint = 0;
    private int lastWaitingPrint = 0;
        
    private SIMMaster(String jar, int tasks, int workers, int taskTime, 
            double crashChance, String inFile) {
        
        // Save all parameters
        this.inFile = inFile;
        this.workerJar = jar; 
        this.maxWorkers = workers;
        this.totalTasks = tasks;
        this.taskTime = taskTime;
        this.crashChance = crashChance;
        
        // Print some info for the user
        System.out.println("SIM Master started.");
        System.out.println("Using input file  : " + inFile);
        System.out.println("Using worker jar  : " + jar);
        System.out.println("Number of tasks   : " + tasks);
        System.out.println("Time per task     : " + taskTime + " sec.");
        System.out.println("Chance of crash   : " + crashChance);
        
        // Press start on the stopwatch  
        startTime = System.currentTimeMillis();    
    }
    
    /* (non-Javadoc)
     * @see joinc.Master#totalTasks()
     */
    public int totalTasks() {
        return totalTasks;        
    }
      
    /* (non-Javadoc)
     * @see joinc.Master#maximumWorkers()
     */
    public int maximumWorkers() {
        return maxWorkers; 
    }
    
    // Prints the status of the application (the percentage of 
    // tasks done). This gives the user something to look at ;-)
    private void printStatus(boolean mayWait) {
        
        int tasksWaiting = totalTasks - nextTaskNumber; 
        int tasksRunning = totalTasks - (tasksWaiting + tasksFinished);
                
        if (tasksFinished == lastFinishedPrint && 
                lastWaitingPrint == tasksWaiting) {
            
            // nothing new to print...
            if (mayWait) { 
                try { 
                    Thread.sleep(2000);
                } catch (Exception e) {
                    // ignore
                }                
            }            
            return;
        }
                               
        StringBuffer out = new StringBuffer("Tasks waiting ");
        out.append(tasksWaiting);    
        out.append(" / running ");        
        out.append(tasksRunning);
        out.append(" / finished ");        
        out.append(tasksFinished);
        
        // Remember what we printed, so we don't print things twice
        lastFinishedPrint = tasksFinished;
        lastWaitingPrint = tasksWaiting;
        
        // ... and finally print it!
        System.out.println(out.toString());
    }
      
    /* (non-Javadoc)
     * @see joinc.Master#idle()
     */
    public void idle() {
        printStatus(true);
    }
    
    /* (non-Javadoc)
     * @see joinc.Master#getTask()
     */
    public Task getTask() {
        
        // To generate a task, we simply create a task object and fill it with 
        // all the required information. All tasks are basically the same, they
        // just have different task numbers. 
        String stdout = "stdout." + nextTaskNumber;
        String stderr = "stderr." + nextTaskNumber;        
        String outputFile = "result." + nextTaskNumber;
        
        nextTaskNumber++;
        
        String [] parameters = new String[4];
        parameters[0] = inFile;
        parameters[1] = outputFile; 
        parameters[2] = "" + taskTime;
        parameters[3] = "" + crashChance;
        
        // Print some stuff to keep the user up to date
//        printStatus(false);
        
        return new Task("applications.sim.SIMWorker", stdout, stderr, 
                null, parameters, new String [] { workerJar }, 
                new String [] { inFile }, new String [] { outputFile });
    }
    
    // Used to remove the output files produced by the tasks.
    private void deleteFile(String filename) { 
        File file = new File(filename);
        file.delete();                
    }
    
    // Checks if an output exists, and if it contains the correct data.
    private void readResult(String filename, int taskNumber) {
        String result = null;
        double time = -1;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            
            String line = reader.readLine();
            
            while (line != null) {               
                if (line.startsWith("Result: ")) { 
                    result = line.substring(8).trim();
                } else if (line.startsWith("Time: ")) {                                   
                    time = Double.parseDouble(line.substring(6).trim());                
                } 
                
                line = reader.readLine();
            }

            // Check if everything is there...            
            if (time < 0 || result == null) {
                // We are missing some parts of the output!!
                String s = "Output of task " + taskNumber + " not complete!";
                taskErrors.add(s);   
                tasksFailed++;
                return;
            }
                
            // The file is present and correct, so store the time and result.
            totalWorkerTime += time;  

        } catch (FileNotFoundException e) {
            String s = "Output of task " + taskNumber + " not found!";
            taskErrors.add(s);
            tasksFailed++;
        } catch (IOException e) {
            String s = "Output of task " + taskNumber + " not readable!";
            taskErrors.add(s);
            tasksFailed++;
        }                                    
    }
    
    /* (non-Javadoc)
     * @see joinc.Master#taskDone(joinc.Task)
     */
    public void taskDone(Task job) { 
        
        // When a job has finished, we process the output files.
        tasksFinished++;
        
        // Just remove stderr and stdout 
        deleteFile(job.stdoutFile);
        deleteFile(job.stderrFile);
        
        // Read the result ...
        readResult(job.outputFiles[0], job.taskNumber);
        
        // ... and remove it
        deleteFile(job.outputFiles[0]);
        
        printStatus(false);
    }
    
    // Called when the all tasks are done.
    private void done() {
        
        // Record the calculation time
        long time = System.currentTimeMillis() - startTime;

        // Print the last status line
        printStatus(false);
        System.out.println();

        // Check if all tasks are done
        if (totalTasks == tasksFinished && tasksFailed == 0) {
            System.out.println("Tasks finished: " + tasksFinished + " (OK)");
        } else {
            // Oh dear ... some results are missing!
            System.out.println("Tasks finished: " + tasksFinished + " (!)");
            
            if (totalTasks != tasksFinished) { 
                int missing = totalTasks - tasksFinished;                 
                System.out.println("Tasks missing: " + missing);                    
            }
            
            if (tasksFailed != 0) { 
                System.out.println("Errors in results: " + tasksFailed);
                
                for (int i=0;i<taskErrors.size();i++) { 
                    System.out.println(" - " + taskErrors.get(i));                        
                }                                
            }            
            
            System.exit(1);
        }
        
        // Print the time that we needed.
        System.out.println("Master time: " + (time / 1000) + " sec.");
        System.out.println("Worker time: " + (int)totalWorkerTime + " sec."); 
    }
    
    public static void main(String args[]) {
        
        try {					            
            // Just check the number of parameters and start the master.
            if (args.length != 6) {
                System.err.println("Usage: java SIMMaster <worker.jar> " +
                        "<total tasks> <workers> <time per task (seconds)> " +
                        "<chance of task crash> <input file>");
                
                System.exit(1);				
            }
            String jar = args[0];//"/home/alogo/workspace/gridcomputing/dist/gridcomputing.jar";//args[0]
            String tasks = args[1];//"1";//args[1]
            String workers = args[2];//"1";//args[2]
            String time = args[3];//"1";//args[3]
            String crash = args[4];//"0.5";//args[5]
            String inFile = args[5];//"";
            SIMMaster master = new SIMMaster(jar,   
                    Integer.parseInt(tasks), Integer.parseInt(workers),  
                    Integer.parseInt(time), Double.parseDouble(crash), 
                    inFile);
            
            master.start();
            master.done();
            
        } catch (Exception e) {
            System.err.println("Oops " + e);
            e.printStackTrace(System.err);
        }
    }
}
