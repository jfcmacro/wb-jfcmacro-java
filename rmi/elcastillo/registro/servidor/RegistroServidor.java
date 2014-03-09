/* Definición de una implementación del servidor */
package elcastillo.registro.servidor;

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import elcastillo.registro.Registro;

public class RegistroServidor {

    public static void main(String args[]) {

	try {

	    RegistroServidorImpl rsi = new RegistroServidorImpl(0);
	    Naming.rebind("RegistroOficial", rsi);
	    System.out.println("Registro Oficial esperando peticiones");
	} catch (RemoteException re) {
	    
	    System.err.println("Excepción en Registro Oficial: " + re);
	} catch (MalformedURLException e) {

	    System.err.println("Excepción en Registro Oficial: " + e);
	} catch (Exception e) {

	    System.err.println("Excepción desconocida");
	}
    }
}

	
