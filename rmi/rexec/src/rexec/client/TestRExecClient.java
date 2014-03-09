package rexec.client;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.rmi.Naming;
import rexec.inter.RExec;

public class TestRExecClient {

    public static void main(String[] args) {

	try {
	    Object o = Naming.lookup("rmi://localhost:2048/rexec");
	    RExec rexec = (RExec) o;
	    int rstatus = rexec.compile("/home/fcardona/tmp", "HelloWorld.java");
	    if (rstatus == 0) {
		System.out.println("Se pudo compilar el programa");
	    }
	    else {
		System.out.println("No se pudo compilar el programa");
	    }
	}
	catch (MalformedURLException e) {
	    System.err.println("MalformedURLException: " + e);
	}
	catch (RemoteException e) {
	    System.err.println("RemoteException: " + e);
	}
	catch (NotBoundException e) {
	    System.err.println("NotBoundException: " + e);
	}
    }
}