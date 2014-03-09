// CountRMIServer.java

import java.rmi.*;
import java.rmi.server.*;

public class CountRMIServer {

   public static void main(String args[]) {

      try {

         // Crea CountRMIImpl
         CountRMIImpl myCount = new CountRMIImpl("myCountRMI");
         System.out.println("CountRMI servidor listo");
      } catch (Exception e) {
         System.out.println("Exception: " + e.getMessage());
         e.printStackTrace();
      }
   }
}

