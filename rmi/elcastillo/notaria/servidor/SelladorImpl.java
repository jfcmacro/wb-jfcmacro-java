/* Definición de una implementación del servidor */
package elcastillo.notaria.servidor;

import elcastillo.notaria.Sellador;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Remote;

final public class SelladorImpl 
    implements elcastillo.notaria.Sellador {
   
    public SelladorImpl() 
	throws RemoteException {
	UnicastRemoteObject.exportObject(this);
    }

    public String sellador() 
	throws RemoteException {

	try {
	    Thread.sleep(10000);
	} catch (InterruptedException ie) { }
	return "Este es el sello oficial de la notaria";
    }	
}
