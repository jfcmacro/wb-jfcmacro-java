package elcastillo.cliente_gui;

import java.rmi.Naming;
import elcastillo.notaria.Sellador;
import elcastillo.registro.Registro;
import elcastillo.security.LaxSecurityManager;

public class ClienteGUI {

    public static void main(String []args) {

	if (System.getSecurityManager() == null) {
	    System.setSecurityManager(new LaxSecurityManager());
	}

	try {

	    Sellador s = (Sellador) Naming.lookup("rmi://dis7.eafit.edu.co/SelladorOficial");
	    Registro r = (Registro) Naming.lookup("rmi://dis7.eafit.edu.co/RegistroOficial");

	    System.out.println("Registro: " + r.registrar());
	    System.out.println("Sellador: " + s.sellador());
	} catch (Exception e) {
	    System.err.println("Exception: " + e);
	}
    }
}
