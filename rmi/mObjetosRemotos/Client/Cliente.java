import java.rmi.*;
import java.rmi.server.*;

public class Cliente {


    public static void main(String []args) {


	System.setSecurityManager(new LaxSecurityManager());

	try {

	    ServidorRecursos sr = (ServidorRecursos) Naming.lookup("rmi://localhost/Prueba");

	    Recurso r1 = sr.obtener("Impresora 1");
	    Recurso r2 = sr.obtener("Impresora 2");

	    System.out.println("Invocando Impresora 1: " + r1.probar("prueba"));
	    System.out.println("Invocando Impresora 2: " + r2.probar("reprobar"));


	    System.out.println("ServidorRecursosImpl listo");
	} catch (Exception e) {
	    System.out.println("Excepción: " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
