package co.edu.eafit.dis.xmlexec;

import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ClienteSocket {

    public static void main(String args[]) {

	try {
	    URL url = new URL("http://localhost:9999/xmlrpc");

	    URLConnection urlCon = url.openConnection();

	    urlCon.setDoInput(true);
	    urlCon.setDoOutput(true);
	    urlCon.setRequestProperty("User-Agent", "Personal");
	    urlCon.setRequestProperty("Host", "localhost");
	    urlCon.setRequestProperty("Content-Type", "text/xml");
	    // urlCon.setUseCaches(true);

	    StringWriter sw = new StringWriter();
	    sw.write("<?xml version=\"1.0\"?>\r\n");
	    sw.write("<methodCall>\r\n");
	    sw.write("<methodName>Servidor1.sumar</methodName>\r\n");
	    sw.write("<params>\r\n");
	    sw.write("<param>\r\n");
	    sw.write("<value><i4>10</i4></value>\r\n");
	    sw.write("</param>\r\n");
	    sw.write("<param>\r\n");
	    sw.write("<value><i4>30</i4></value>\r\n");
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
