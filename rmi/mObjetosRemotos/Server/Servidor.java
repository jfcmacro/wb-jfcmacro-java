import java.rmi.*;
import java.rmi.server.*;

public class Servidor {

    public static void main(String []args) {

	// System.setSecurityManager(new RMISecurityManager());

	try {
	    ServidorRecursosImpl sr = new ServidorRecursosImpl("Prueba");
	    System.out.println("ServidorRecursosImpl listo");
	} catch (Exception e) {
	    System.out.println("Excepción: " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
