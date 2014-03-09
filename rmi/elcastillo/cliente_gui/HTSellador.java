package elcastillo.cliente_gui;

import elcastillo.notaria.Sellador;
import javax.swing.JTextField;

class HTSellador implements Runnable {

    HTSellador(Sellador s, JTextField tf) {
	this.s = s;
	this.tf = tf;
    }

    Sellador s;
    JTextField tf;

    public void run() {

	try {
	    tf.setText(s.sellador());
	} catch (Exception e) {
	    System.err.println("Error en: " + e);
	    System.exit(1);
	}
    }

}
