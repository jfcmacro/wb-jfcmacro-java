import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String []args) {

	try {
	    
	    if (args.length != 2) {

		System.err.println("Uso: ");
		System.exit(1);
	    }
	    
	    String host = args[0];
	    int puerto = Integer.parseInt(args[1]);

	    Peticion peticion = new Peticion(host, puerto);

	    for (int i = 0; i < 10; i++) {
		System.out.println(peticion.obtenerConsecutivo());
	    }
		
	    } catch (SocketException se) {
	    } catch (UnknownHostException uhe) {
	    } catch (IOException ioe) {
	    } catch (Peticion.TimeoutErrorException tee) {
		System.err.println("No se pudo obtener los consecutivos");
		System.exit(1);
	    }
    }
}
