package applications.sim;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.UnknownHostException;

/**
 * Example JOINC worker application designed to test if the following features 
 * of JOINC work:
 * 
 *    - jobs submission
 *    - parameter passing 
 *    - input file stage in
 *    - output file stage out
 *    - fault-tolerance      
 *  
 * This worker application read a simple input file, sleeps for a while, 
 * then produces a simple output file. A command-line parameter determines the 
 * chance that the job will crash. 
 *  
 * @author Jason Maassen
 * @version 2.0 Feb 8, 2006
 * @since 1.0
 */
public class SIMWorker {
    
    public static void main(String args[]) {        
        // Record the start time
        long start = System.currentTimeMillis();
        
        // Check the number of parameters first
        if (args.length != 4) { 
            System.err.println("Expecting 4 parameters, got " + args.length);
            for (int i=0;i<args.length;i++) { 
                System.err.println(" " + i + " -> " + args[i]);                        
            }                
            System.exit(1);
        }
        
        // Read all parameters and check their type and value
        String inputfile = args[0];
        String outputfile = args[1];
        
        int time = 0; 
        
        try { 
            time = Integer.parseInt(args[2]);
        } catch (Exception e) { 
            System.err.println("Parameter 2 should be an int, got " + args[2]);
            System.exit(1);            
        } 
        
        double crash = 0.0;
        
        try { 
            crash = Double.parseDouble(args[3]);
        } catch (Exception e) { 
            System.err.println("Parameter 3 should be a double, got " + args[3]);
            System.exit(1);            
        } 
        
        // Read the input file, will perform exit(1) if it fails.
        try {         
            BufferedReader in = new BufferedReader(new FileReader(inputfile));
            // Check the contents of the input file.             
            if (!in.readLine().equals("Hello world")) {
                System.err.println("Input file \"" + inputfile + 
                "\" does not contain expected data");                
                System.exit(1);
            }
        } catch (Exception e) { 
            System.err.println("Input file \"" + inputfile + "\" not found");                
            System.exit(1);
        }
        
        // Pick a number to decide we have to crash
        double rand = Math.random();
        
        if (rand < crash) { 
            // We should crash
            System.err.println("This task was ordered to crash");                
            System.exit(1);
        } 
        
        // Now sleep for the specified time 
        try { 
            Thread.sleep(time * 1000);
        } catch (Exception e) { 
            // ignored
        }
        
        // Record the end time
        long end = System.currentTimeMillis();

        // Write the output file
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(outputfile));
            out.write("Result: Goodbye world\n");
            out.write("Time: " + ((end-start)/1000.0) + "\n");            
            out.close();
        } catch (Exception e) {
            System.err.println("Failed to write output file: " + e);                
            System.exit(1);
        }    
    }
    
    private static void wherAmI(){
        java.io.File f = new java.io.File(".");
        if(f.isDirectory()){
            for(int i=0;i<f.list().length;i++){   
                System.out.println( new java.io.File( f.list()[i] ).getAbsolutePath() );
            }
        }       
            java.util.Properties p = System.getProperties();
            java.util.Enumeration keys = p.keys();
            String key;
             System.out.println("I was sent to: \n");
        java.net.InetAddress addr=null;
        try {
            addr = java.net.InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

            // Get IP Address
            byte[] ipAddr = addr.getAddress();
            // Get hostname
             System.out.println("Hostname : "+addr.getHostName()+"\n");
             System.out.println("hostnameCanonical : "+addr.getCanonicalHostName()+"\n");

            // Convert to dot representation
            String ipAddrStr = "";
            for (int i=0; i<ipAddr.length; i++) {
                if (i > 0) {
                    ipAddrStr += ".";
                }
                ipAddrStr += ipAddr[i]&0xFF;
        }
             System.out.println("IP : "+ipAddrStr+"\n");
                        
            while( keys.hasMoreElements() ) {
                key = (String)keys.nextElement();
                 System.out.println(key +" : "+System.getProperty(key)+"\n");
            }
    }
}