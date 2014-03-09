package co.edu.eafit.dis.xmlcal;

import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ClienteXML {

    public static void main(String args[]) {

	if (args.length != 2) {
	    System.err.println("Uso: Calculadora.Cliente.ClienteXML val1 val2");
	    System.exit(1);
	}

	try {


	    URL url = new URL("http://localhost:9999/RPC2");

	    URLConnection urlCon = url.openConnection();

	    urlCon.setDoInput(true);
	    urlCon.setDoOutput(true);
	    urlCon.setRequestProperty("User-Agent", "Personal");
	    urlCon.setRequestProperty("Host", "dis7.eafit.edu.co");
	    urlCon.setRequestProperty("Content-Type", "text/xml");
	    // urlCon.setUseCaches(true);

	    StringWriter sw = new StringWriter();
	    sw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n");
	    sw.write("<methodCall>\r\n");
	    sw.write("<methodName>Servidor1.sumar</methodName>\r\n");
	    sw.write("<params>\r\n");
	    sw.write("<param>\r\n");
	    sw.write("<value><i4>" + args[0] + "</i4></value>\r\n");
	    sw.write("</param>\r\n");
	    sw.write("<param>\r\n");
	    sw.write("<value><i4>" + args[1] + "</i4></value>\r\n");
	    sw.write("</param>\r\n");
	    sw.write("</params>\r\n");
	    sw.write("</methodCall>\r\n");

	    String content = sw.toString();

	    urlCon.setRequestProperty("Content-length", ""+content.length());

	    OutputStream os = urlCon.getOutputStream();

	    os.write(content.getBytes());
	    os.close();

	    urlCon.connect();

	    BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

	    String linea = null;
	    while ((linea = br.readLine()) != null) {
		System.out.println(linea);
	    }

	    br.close();

	} catch (Exception e) {
	    System.err.println("Error: " + e);
	    System.exit(1);
	}
    }
}
