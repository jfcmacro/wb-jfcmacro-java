import java.io.*;
import java.net.*;

public class Client {

    public static void main(String []args) {

	//try {

	    if (args != 2) {

		System.err.println("Uso: ");
		System.exit(1);
	    }
	    
	    String host = argv[0];
	    int puerto = Integer.parseInt(argv[1]);

	    Peticion peticion = new Peticion(host, puerto);

	    for (int i = 0; i < 10; i++) {
		peticion.obtenerConsecutivo();
	    }
		
	    //	} catch () {
	    //}
    }
}
