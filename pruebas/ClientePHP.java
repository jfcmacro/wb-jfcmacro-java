import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ClientePHP {
	
    public static void main(String args[]) {
	
	try {
	    
	    
	    URL url = new URL("http://dis7.eafit.edu.co/prueba.php");
	    
	    URLConnection urlCon = url.openConnection();
	    
	    urlCon.setDoInput(true);
	    urlCon.setDoOutput(true);
	    urlCon.setRequestProperty("User-Agent", "Personal");
	    urlCon.setRequestProperty("Host", "dis7.eafit.edu.co");
	    urlCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	    // urlCon.setUseCaches(true);
	    
	    StringWriter sw = new StringWriter();
	    sw.write("myrb=Cap&mycb=crema&mycb=Azucar&termino=Descafinado");
			
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
