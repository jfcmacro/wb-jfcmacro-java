// Mantiene y gestiona un conjunto de recursos remotos

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorRecursos extends Remote
{
    public Recurso obtener(String nombre)
	throws RemoteException;
    public void registrar(String nombre, Recurso recurso)
	throws RemoteException;
    public void borrar(String nombre)
	throws RemoteException;
}
