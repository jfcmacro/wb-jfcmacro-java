/* Definición de una implementación del servidor */
package elcastillo.notaria.servidor;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;

public class SelladorServidor {

    public static void main(String args[]) {

	try {

	    SelladorImpl ssi = new SelladorImpl();
	    Naming.rebind("SelladorOficial", ssi);
	    System.out.println("Sellador Oficial esperando peticiones");
	} catch (RemoteException re) {
	    
	    System.err.println("Excepción en Sellador Oficial: " + re);
	} catch (MalformedURLException e) {

	    System.err.println("Excepción en Sellador Oficial: " + e);
	} catch (Exception e) {

	    System.err.println("Excepción desconocida");
	}
    }
}

	
