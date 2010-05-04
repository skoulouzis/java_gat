package applications.prime;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Simple JOINC worker application that computes prime factors of a number.
 * This number is provides as a command line parameter. The result is written 
 * to an output file (whose name is a command line parameter). 
 *  
 * @author Jason Maassen
 * @version 1.0 Feb 8, 2006
 * @since 1.0
 * 
 */
public final class PrimeWorker {

    // String buffer used to gather the result 
    private static final StringBuffer result = new StringBuffer();

    // The first result is printed differently. 
    private static boolean first = true;

    
    /**
     * Determines if a number is prime
     * 
     * @param n the number to check
     * @return boolean indicating if the number is prime
     */
    private static final boolean isPrime(long n) {

        if (n == 2) {
            return true;
        }

        if ((n % 2) == 0) {
            return false;
        }

        long sqrn = (long) Math.sqrt(n) + 1;

        for (long i = 3; i <= sqrn; i += 2) {
            if ((n % i) == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Add a partial result (times * factor) to the result buffer.
     * 
     * @param times the number of times the factor should be added
     * @param factor the factor found
     */
    private static final void foundFactor(int times, long factor) {

        if (!first) {
            result.append(" * ");
        } else {
            first = false;
        }

        for (int i=0;i<times;i++) { 
            result.append(factor);
            
            if (i != times-1) { 
                result.append(" * ");    
            }
        }
    }

    /**
     * Split a number into prime factors
     * 
     * @param n the number to factorize
     */
    private static final void factor(long n) { 

        for (long i = 2; i <= n; i++) {
            if ((n % i) == 0) {
                if (isPrime(i)) {
                    long nn = n;
                    int times = 0;
                    while ((nn % i) == 0) {
                        nn /= i;
                        times++;
                    }
                    foundFactor(times, i);
                }
            }
        }
    }

    /**
     * Check if the worker is being run on a 'restricted' machine. 
     * 
     * To prevent users from accidently running all compute jobs on the frontend
     * machine (causing enormous load), we check what machine we are on, and 
     * refuse to start if it is one of the DAS-2 frontends.  
     */
    private static void checkMachine() { 
        
        // List of restricted machines
        String [] restrictedHosts = new String[] { "fs0.das2.cs.vu.nl", "fs0",         
                "fs1.das2.liacs.nl", "fs1", "fs2.das2.nikhef.nl", "fs2", 
                "fs3.das2.ewi.tudelft.nl", "fs3", "fs4.das2.phys.uu.nl", "fs4"};
        
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            
            for (int i=0;i<restrictedHosts.length;i++) { 
                if (hostname.equals(restrictedHosts[i])) { 
                    System.err.println("You are running a worker on a frontend "
                            + "machine (" + restrictedHosts[i] + "). This is "
                            + "not allowed!");
                    System.exit(1);
                }
            }                        
        } catch (UnknownHostException e) {
            // ignore and hope for the best...
        }
    }    
    
    public static void main(String[] args) {

        // Check what machine we are on. 
        checkMachine();
        
        try {
            // Read the input problem            
            PrintStream out = System.out;
            long N = 1;

            if (args.length >= 1) {
                N = Long.parseLong(args[0]);

                // Read output file name -- if present
                if (args.length == 2) {
                    out = new PrintStream(new FileOutputStream(args[1]));
                }

            } else {
                System.err.println("Usage: java applications.prime.FactorWorker" 
                        + " <n> <output filename>");
                System.exit(1);
            }

            // Start facorization 
            out.println("Factoring: " + N);

            long start = System.currentTimeMillis();

            factor(N);

            long end = System.currentTimeMillis();
            double time = (end - start) / 1000.0;

            // Print result and time required...            
            out.println("Result: " + result);
            out.println("Time: " + time);
            out.flush();
            out.close();
        } catch (Exception e) {
            System.err.println("Application failed!: " + e);
            System.exit(1);
        }
    }
}