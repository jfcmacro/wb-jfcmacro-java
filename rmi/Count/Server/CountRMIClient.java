// CountRMIClient.java RMI Count Client

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class CountRMIClient
{
   public static void main(String args[]) {
      // System.setSecurityManager(new RMISecurityManager());
      try {
         CountRMI myCount = (CountRMI) Naming.lookup("rmi://"+
						     args[0] + "/" +
						     "myCountRMI");

         System.out.println("Setting Sum to 0");
         myCount.sum(0);

         long startTime = System.currentTimeMillis();
         // Increment 1000 times
         System.out.println("Incrementing");
         for (int i = 0; i < 10000; i++) {
            myCount.increment();
         }

         // Calculate stop time; print out statistics
         long stopTime = System.currentTimeMillis();
         System.out.println("Avg Ping=" + ((stopTime - startTime)/1000f)
                                        + "msecs");
         System.out.println("Sum = " + myCount.sum());
     } catch (Exception e) {
       System.out.println("System exception " + e);
     }
     System.exit(0);
   }
}
