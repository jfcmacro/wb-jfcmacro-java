import java.rmi.*;
import java.rmi.server.*;

public class ServidorImpresoras {

    public static void main(String []args) {

	// System.setSecurityManager(new RMISecurityManager());

	try {
	    RecursoImpresora ri1 = new RecursoImpresora("Imp1");
	    RecursoImpresora ri2 = new RecursoImpresora("Imp2");

	    ServidorRecursos sr = (ServidorRecursos) Naming.lookup("rmi://localhost/Prueba");

	    sr.registrar("Impresora 1", ri1);
	    sr.registrar("Impresora 2", ri2);

	    System.out.println("ServidorRecursosImpl listo");
	} catch (Exception e) {
	    System.out.println("Excepción: " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
