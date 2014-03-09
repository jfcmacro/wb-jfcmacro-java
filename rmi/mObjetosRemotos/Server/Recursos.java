// Interface que implementa un recurso de algún tipo
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Recurso extends Remote
{
    public String probar(String nombre)
	throws RemoteException;;
}


