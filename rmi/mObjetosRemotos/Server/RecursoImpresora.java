// Implementa la interface ServidorRecursos

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.net.MalformedURLException;

public class RecursoImpresora 
    extends UnicastRemoteObject
    implements Recurso
{
    private String nombre;

    public RecursoImpresora(String nombre) 
	throws RemoteException, MalformedURLException  {
	super();
	this.nombre = nombre;
	Naming.rebind(nombre, this);
    }

    public String probar(String valor) {
	return valor + " " + nombre;
    }
} 
