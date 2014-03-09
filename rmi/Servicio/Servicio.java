import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servicio extends Remote {
	public String conectar(int id) throws RemoteException;
	public int solicitarPeticion(String clave, int valor) throws RemoteException;
	public void terminar(String clave) throws RemoteException;
}
