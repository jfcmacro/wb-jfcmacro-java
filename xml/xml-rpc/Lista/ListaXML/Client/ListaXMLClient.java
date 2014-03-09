package ListaXML.Client;

import org.apache.xmlrpc.XmlRpcClient;
import java.util.Vector;

public class ListaXMLClient {

    public static void main(String args[]) {

	try {
	    // Esta instancia de XmlRpcClient
	    // se conectará donde se encuentra nuestro servidor
	    XmlRpcClient cliente = 
		new XmlRpcClient("http://127.0.0.1:9999/RPC2");

	    // Una instancia de vector almacenará los argumentos
	    Vector listaDeArgumentos = new Vector();
	    
	    listaDeArgumentos.add(new String("Juan"));
	    
	    // Invocamos el método con el servidor obtenido

	    Boolean resultado = (Boolean) cliente.execute("Lista.adicionar",
							  listaDeArgumentos);

	    if (resultado.booleanValue()) {
		System.out.println("Adicionado: Juan");
	    }
	    else {
		System.out.println("No se pudo adicionar");
	    }

	    // Reintentamos adicionar a Juan

	    resultado = (Boolean) cliente.execute("Lista.adicionar",
						  listaDeArgumentos);

	    if (resultado.booleanValue()) {
		System.out.println("Adicionado: Juan");
	    }
	    else {
		System.out.println("No se pudo adicionar");
	    }

	    // Borramos a Juan

	    resultado = (Boolean) cliente.execute("Lista.borrar",
						  listaDeArgumentos);

	    if (resultado.booleanValue()) {
		System.out.println("Borrado Juan");
	    }
	    else {
		System.out.println("No se pudo borrar");
	    }
	} catch (Exception e) {
	    System.out.println("Exception: " + e);
	    System.exit(1);
	}
    }
}
	    
	    
