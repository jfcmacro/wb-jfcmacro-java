import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String []args) {

	try {
	    
	    if (args.length != 2) {

		System.err.println("Uso: Servidor puerto consecutivoInicial");
		System.exit(1);
	    }
	    
	    int puerto = Integer.parseInt(args[0]);
	    int cons   = Integer.parseInt(args[1]);

	    Respuesta respuesta = new Respuesta(puerto, cons);

	    respuesta.ejecutar();

	} catch (Exception e) {
		System.err.println("No se pudo inciar el servidor debido a:"
				   + e);
		System.exit(1);
	}
    }
}
