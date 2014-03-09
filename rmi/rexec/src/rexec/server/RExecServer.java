package rexec.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import rexec.impl.RExecImpl;

public class RExecServer {

    public static void main(String[] args) {
	try {
	    RExecImpl rexec = new RExecImpl();
	    System.out.println("Listo para enlazar el servidor al equipo local");
	    Naming.rebind("rexec", rexec);
	    System.out.println("El servidor está esperando por peticiones");
	} 
	catch (RemoteException re) {
	    System.err.println("Exception: en rexec.server.RExecServer.main" + re);
	}
	catch (MalformedURLException mfue) {
	    System.err.println("MalformedURLException: " + mfue);
	}
    }
}