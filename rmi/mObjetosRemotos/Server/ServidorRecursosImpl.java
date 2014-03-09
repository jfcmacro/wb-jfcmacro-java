// Implementa la interface ServidorRecursos

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.HashMap;
import java.rmi.Naming;
import java.net.MalformedURLException;

public class ServidorRecursosImpl
    extends UnicastRemoteObject
    implements ServidorRecursos
{
    private Map map = new HashMap();

    public ServidorRecursosImpl(String nombre)
	throws RemoteException, MalformedURLException {
	super();
       
	Naming.rebind(nombre, this);
    }

    public Recurso obtener(String nombre)
	throws RemoteException {
	
	return (Recurso) map.get(nombre);
    }

    public void registrar(String nombre, Recurso recurso)
	throws RemoteException {
	
	map.put(nombre, recurso);
    }

    public void borrar(String nombre)
	throws RemoteException {
	map.remove(nombre);
    }
}
