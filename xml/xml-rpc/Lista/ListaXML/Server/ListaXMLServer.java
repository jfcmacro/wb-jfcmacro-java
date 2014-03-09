package ListaXML.Server;

import org.apache.xmlrpc.WebServer;

public class ListaXMLServer {

    public static void main(String []args) {

	try {

	    // Se crea un servidor de http para escuchar en el
	    // puerto 9999
	    WebServer serverHttp = new WebServer(9999);

	    // Permite todo
	    serverHttp.setParanoid(false);

	    // Establece la clase que implementa los servicios
	    // Y establece un nombre para dicha clase
	    serverHttp.addHandler("Lista", new ListaXMLImpl());

	    // Crea un nuevo hilo de ejecución para 
	    // escuchar las conexiones
	    
	    (new Thread(serverHttp)).start();
	    System.out.println("Servidor activo");
	} catch (Exception e) {
	    System.err.println("Exception: " + e);
	    System.exit(1);
	} finally {
	}
    }
}

	    
