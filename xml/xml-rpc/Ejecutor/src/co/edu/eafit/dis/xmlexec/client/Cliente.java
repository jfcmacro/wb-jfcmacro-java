package co.edu.eafit.dis.xmlexec.client;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import java.util.Map;
import java.net.URL;

public class Cliente {

    public static void main(String args[]) {

	try {

	    XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
	    config.setServerURL(new URL("http://localhost:9999/xmlrpc"));
	    XmlRpcClient cliente = new XmlRpcClient();
	    cliente.setConfig(config);
	    String nombreDeRuta = new String("HelloWorld.java");
	    String archivo      = new String("public class HelloWorld { public static void main(String[] args) { System.out.println(\"Hola Mundo\"); } }\n");
	    System.out.println("longitud archivo: " + archivo.length());
	    Object[] parametros = new Object[] { nombreDeRuta,
					         archivo
	    };

	    Map<String,String> resultado = (Map<String,String>)
		cliente.execute("Ejecutor.compilarJavaFile", parametros);

	    int codterm = Integer.parseInt(resultado.get("codterm"));
	    if (codterm == 0) {
		System.out.println("output:\n" + resultado.get("output"));
	    }
	    else {
		System.out.println("error:\n" + resultado.get("error"));
	    }

    	    resultado = (Map<String,String>)
		cliente.execute("Ejecutor.execCompJavaFile", parametros);

	    codterm = Integer.parseInt(resultado.get("codterm"));
	    if (codterm == 0) {
		System.out.println("output:\n" + resultado.get("output"));
	    }
	    else {
		System.out.println("error:\n" + resultado.get("error"));
	    }

	} catch (Exception e) {

	    System.out.println("Exception: " + e);
	    System.exit(1);
	}
    }
}
