package elcastillo.cliente_gui;

import elcastillo.registro.Registro;
import javax.swing.JTextField;

class HTRegistro implements Runnable {

    HTRegistro(Registro r, JTextField tf) {
	this.r = r;
	this.tf = tf;
    }

    Registro r;
    JTextField tf;

    public void run() {

	try {
	    tf.setText("" + r.registrar());
	} catch (Exception e) {
	    System.err.println("Error en: " + e);
	    System.exit(1);
	}
    }

}
