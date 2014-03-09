package co.edu.eafit.dis.xmlcal.client;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;

public class Cliente {

    public static void main(String args[]) {

	try {

	    XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
	    config.setServerURL(new URL("http://localhost:9999/xmlrpc"));
	    XmlRpcClient cliente = new XmlRpcClient();
	    cliente.setConfig(config);
	    Object[] parametros = new Object[]{new Integer(33), new Integer(9)};
	    Integer resultado   = (Integer) cliente.execute("Calculadora.sumar", parametros);

	    System.out.println("La suma final es: " + resultado);

	} catch (Exception e) {

	    System.out.println("Exception: " + e);
	    System.exit(1);
	}
    }
}
