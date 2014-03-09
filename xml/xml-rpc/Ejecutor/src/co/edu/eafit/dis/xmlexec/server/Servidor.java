package co.edu.eafit.dis.xmlexec.server;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;


public class Servidor {

    public static void main(String []args) {

	try {
	    WebServer webServer = new WebServer(9999);
	    XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
	    PropertyHandlerMapping phm = new PropertyHandlerMapping();
	    // phm.setVoidMethodEnabled(true);
	    phm.addHandler("Ejecutor", EjecutorImpl.class);

	    // phm.addHandler("Calculator", CalcImpl.class);
	    // System.out.println("Handle registrado: " + Calculator.class.getName());
	    // System.out.println("Clase: " + CalcImpl.class.toString());
	    xmlRpcServer.setHandlerMapping(phm);

	    XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();

	    serverConfig.setEnabledForExtensions(true);
	    serverConfig.setContentLengthOptional(true);
	    webServer.setParanoid(false);
	    webServer.start();

	} catch (Exception e) {
	    System.err.println("Exception: " + e);
	    System.exit(1);
	} finally {
	}

    }
}
