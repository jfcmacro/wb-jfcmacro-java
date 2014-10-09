// CountRMIServer.java

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class CountRMIServer {

   public static void main(String args[]) {

       if (System.getSecurityManager() == null) {
	   System.setSecurityManager(new SecurityManager());
       }
       try {
	   // Crea CountRMIImpl
	   String name = "myCountRMI";
	   CountRMI myCount = new CountRMIImpl();
	   CountRMI stub = 
	       (CountRMI) UnicastRemoteObject.exportObject(myCount, 2001);
	   Registry registry = LocateRegistry.getRegistry();
	   registry.rebind(name, stub);
	   System.out.println("CountRMI servidor listo");
       } catch (Exception e) {
	   System.out.println("Exception: " + e.getMessage());
	   e.printStackTrace();
       }
   }
}

