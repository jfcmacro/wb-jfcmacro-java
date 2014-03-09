/* Definición de una implementación del servidor */
package elcastillo.registro.servidor;

import elcastillo.registro.Registro;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Remote;

final class RegistroServidorImpl 
    implements elcastillo.registro.Registro {
    
    private int nRegistro;

    public RegistroServidorImpl(int nRegistro) 
	throws RemoteException {
	UnicastRemoteObject.exportObject(this);
    }

    public int registrar() 
	throws RemoteException {

	try {
	    Thread.sleep(10000);
	} catch (InterruptedException ie) { }
	return nRegistro++;
    }	
}
