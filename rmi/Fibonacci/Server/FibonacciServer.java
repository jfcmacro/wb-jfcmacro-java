import java.net.*;
import java.rmi.*;

public class FibonacciServer {

   public static void main(String args[]) {

      try {
         FibonacciImpl f = new FibonacciImpl();
         Naming.rebind("fibonacci", f);
         System.out.println("Fibonacci Server Ready");
      } catch (RemoteException re) {
         System.out.println("Excepcion en FibonaciImpl.main: " + re);
         re.printStackTrace();
      } catch (MalformedURLException mfue) {
         System.out.println(mfue);
         mfue.printStackTrace();
      } 
   }
}
