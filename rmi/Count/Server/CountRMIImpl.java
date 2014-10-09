// CountRMIImpl.java, CountRMI implementation

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.Naming;

public class CountRMIImpl
    implements CountRMI {

   private int sum;

    public CountRMIImpl() {
   }

   public int sum() throws RemoteException {
      return sum;
   }

   public void sum(int val) throws RemoteException {
      sum = val;
   }

   public int increment() throws RemoteException {
      sum++;
      return sum;
   }
}
