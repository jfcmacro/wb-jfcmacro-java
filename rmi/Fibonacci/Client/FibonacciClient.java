import java.rmi.*;
import java.net.*;
import java.math.BigInteger;

public class FibonacciClient {

   public static void main(String args[]) {

      if (args.length == 0 || !args[0].startsWith("rmi:")) {
         System.err.println("Uso: java FibonacciClient rmi://host.domain.port:/fibonacci number");
         System.exit(1);
      }

      if (System.getSecurityManager() == null) {
		  System.out.println("Instalo el manejador");
		  System.setSecurityManager(new LaxSecurityManager());
      }

      try {

         Object o = Naming.lookup(args[0]);
         Fibonacci calculador = (Fibonacci) o;

         for (int i = 1; i < args.length; i++) {
            try {

               BigInteger indice = new BigInteger(args[i]);
               BigInteger f = calculador.getFibonacci(indice);
               System.out.println("El " + args[i] + "-esimo numero Fibonacci es: " + f);
            } catch (NumberFormatException e) {
               System.err.println(args[i] + "no es un entero");
            }
         }
      } catch(MalformedURLException e) {
         System.err.println(args[0] + " no es un URL RMI valido");
      } catch(RemoteException e) {
         System.err.println("El objeto remoto lanzo una excepcion: " + e);
      } catch(NotBoundException e) {
         System.err.println("No pudo encontrar el objeto remoto en el servidor");
      }
   }
}
 
