package applications.prime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import joinc.Master;
import joinc.Task;

/**
 * Simple JOINC master application that generates prime factorization jobs.
 * These jobs have the following properties: 
 * 
 *    - the jobs have no input file, only input parameters
 *    - the jobs produce an output file
 *    - each job is independent from all others
 *    - all jobs have approximately the same run time 
 *  
 * @author Jason Maassen
 * @version 1.0 Feb 8, 2006
 * @since 1.0
 * 
 */
public class PrimeMaster extends Master {
    
    private static final boolean VERBOSE = false;

    // The name of the jar file containing the worker
    private final String workerJar;

    // The maximum number of workers to use
    private final int maxWorkers;

    // Start time of the master
    private final long startTime;
    
    // The total number of tasks generated
    private final int totalTasks;

    // The next task that will be started
    private int nextTaskNumber = 0;
       
    // The number of tasks finished
    private int tasksFinished;
    
    // Number of tasks failed (e.g., output not found/unreadable/incomplete)
    private int tasksFailed;
    
    // Decription of failed tasks
    private ArrayList taskErrors = new ArrayList();

    // List containing all tasks
    private final String [] results;
    
    // The total time spend by the workers
    private double totalWorkerTime = 0.0;

    // The last status line printed
    private int lastFinishedPrint = 0;
    private int lastWaitingPrint = 0;
    
    // The next number to factor
    private long nextJob = 1234567890;
    
    private PrimeMaster(int jobs, int workers, String workerJar) { 
        this.maxWorkers = workers;
        this.totalTasks = jobs;
        this.workerJar = workerJar;
        this.results = new String[jobs];         
        this.startTime = System.currentTimeMillis();
        
        System.out.println("PrimeMaster started");
        System.out.println("Using worker jar: " + workerJar);
        System.out.println("Number of tasks : " + jobs);
    }
    
    /* (non-Javadoc)
     * @see joinc.Master#getTask()
     */
    public Task getTask() {

        // Check if all tasks have already been returned...
        if (nextTaskNumber == totalTasks) {
            return null;
        }
                
        // Get the next number to factor
        String job = "" + nextJob;        
                
        // Create names for the output files
        String stdout = "stdout." + nextTaskNumber;
        String stderr = "stderr." + nextTaskNumber;
        String outputFile = "result." + nextTaskNumber;

        if (VERBOSE) {
            System.err.println("Created task " + job + " " + outputFile);
        }
        
        // Store the task, so we can check it later
        results[nextTaskNumber] = job;
        
        // Generate a new number to factor, and increment the task counter
        nextJob++;
        nextTaskNumber++;
                
        // Print some stuff to keep the user up to date
        printStatus(false);
        
        // Then return a Task object containing all required info.
        return new Task("applications.prime.PrimeWorker", stdout, stderr,
                "/dev/null",  new String[] { job, outputFile }, 
                new String[] { workerJar }, new String[0], 
                new String[] { outputFile });
    }

    /**
     * Delete a file.
     * 
     * @param filename file to delete.
     */
    private void deleteFile(String filename) {
        File file = new File(filename);
        file.delete();
    }
    
    /**
     * Read an output file produced by the worker. 
     * The following three lines are expected: 
     * 
     *   Factoring: <string>
     *   Result: <string>
     *   Time: <double>
     * 
     * The String after factoring must have the same value as the original input
     * value provided to the worker. This is checked, and the output is rejected
     * if the values are different.    
     * 
     * If the file is missing or could not be parsed, the result will be 
     * rejected. The masters will remeber this and print an error at the end of 
     * the run.  
     * 
     * @param filename worker output file to read.
     * @param taskNumber task that produced this file. 
     */
    private void readResult(String filename, int taskNumber) {
        
        String problem = null;        
        String result = null;
        double time = -1;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            
            String line = reader.readLine();
            
            while (line != null) {
                
                if (line.startsWith("Factoring: ")) { 
                    problem = line.substring(11).trim();
                } else if (line.startsWith("Result: ")) { 
                    result = line.substring(8).trim();
                } else if (line.startsWith("Time: ")) {                                   
                    time = Double.parseDouble(line.substring(6).trim());                
                } 
                
                line = reader.readLine();
            }

            // Check if everything is there...            
            if (problem == null || time < 0 || result == null) {
                // We are missing some parts of the output!!
                String s = "Output of task " + taskNumber + " not complete!";
                taskErrors.add(s);   
                tasksFailed++;
                return;
            }
                
            // Check the problem number in the file...     
            if (!results[taskNumber].equals(problem)) {
                String s = "Output of task " + taskNumber + " is wrong!";
                taskErrors.add(s);   
                tasksFailed++;
                return;                                
            } 

            // The file is present and correct, so store the time and result.
            totalWorkerTime += time;  
            results[taskNumber] = problem + " -> " + result;                    
            
        } catch (FileNotFoundException e) {
            // File couldn't be opened
            String s = "Output of task " + taskNumber + " not found!";
            taskErrors.add(s);
            tasksFailed++;
        } catch (IOException e) {
            // File was there but wasn't (completely) readable
            String s = "Output of task " + taskNumber + " not readable!";
            taskErrors.add(s);
            tasksFailed++;
        } 
    }
    
    /* (non-Javadoc)
     * @see joinc.Master#taskDone(joinc.Task)
     */
    public void taskDone(Task task) {
        if (VERBOSE) {
            System.err.println("Task " + task.taskNumber + " done");
        }

        // Count the number of finished tasks
        tasksFinished++;
        
        // Just remove stderr and stdout
        deleteFile(task.stdoutFile);
        deleteFile(task.stderrFile);

        // Read the result ...
        readResult(task.outputFiles[0], task.taskNumber);
                           
        // ... and remove the result file
        deleteFile(task.outputFiles[0]);

        // Give the user something to look at.
        printStatus(false);
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

    /**
     * Prints some status information, so the user has something to look at 
     * while waiting. The mayWait parameter indicates if the method is allowed 
     * to wait for a few seconds. This prevent the application eating too much
     * CPU when idle is called repeatedly.  
     * 
     * @param mayWait indicates if the method may sleep for a while 
     */
    private void printStatus(boolean mayWait) {
        
        int tasksWaiting = totalTasks - nextTaskNumber; 
        int tasksRunning = totalTasks - (tasksWaiting + tasksFinished);
                
        if (tasksFinished == lastFinishedPrint && 
                lastWaitingPrint == tasksWaiting) {            
            // Nothing new to print, so go to sleep 
            if (mayWait) { 
                try { 
                    Thread.sleep(2000);
                } catch (Exception e) {
                    // ignore
                }                
            }            
            return;
        }
                
        // Print the status of the master application
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
        
    /**
     * Print the final result of the application. 
     */
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

        // Print results
        System.out.println("Results:");
        
        for (int i=0;i<results.length;i++) { 
            System.out.println("  " + results[i]);           
        }
        
        System.out.println();
        
        System.out.println("Master time: " + (time / 1000) + " sec.");
        System.out.println("Worker time: " + (int)totalWorkerTime + " sec.");        
    }

    public static void main(String [] args) { 
        try {
            // Just check the number of parameters and start the master.
            if (args.length != 3) {
                System.out.println("Usage: java Server <worker.jar> <jobs>"
                        + " <workers>");
                System.exit(1);
            }

            int jobs = Integer.parseInt(args[1]);
            int machines = Integer.parseInt(args[2]);
            
            PrimeMaster master = new PrimeMaster(jobs, machines, args[0]);  

            master.start();
            master.done();

        } catch (Exception e) {
            System.err.println("Oops " + e);
            e.printStackTrace();
        }
    }
}
