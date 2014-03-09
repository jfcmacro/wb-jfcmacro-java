import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.math.BigInteger;

public class FibonacciImpl 
   implements Fibonacci {
 
   public FibonacciImpl() throws RemoteException {
      UnicastRemoteObject.exportObject(this);
   }

   public BigInteger getFibonacci(int n) throws RemoteException {
      return this.getFibonacci(new BigInteger(Long.toString(n)));
   }

   public BigInteger getFibonacci(BigInteger n) throws RemoteException {

      System.out.println("Calculando para " + n + "-esimo numero");
      BigInteger cero = new BigInteger("0");
      BigInteger uno  = new BigInteger("1");
 
      if (n.equals(cero)) return cero; 
      if (n.equals(uno))  return uno;

      BigInteger i = uno;
      BigInteger a = cero;
      BigInteger b = uno; 

      while (i.compareTo(n) == -1) {
         BigInteger temp = b;
         b = b.add(a);
         a = temp;
         i = i.add(uno);
      }

      return b;
   }
}
