import java.net.*;
import java.io.*;
import java.util.*;

public class EstadoImpresora {

    public static void main(String []args) {

        try {
	    
	    URL u = new URL("http://kyocera5.eafit.edu.co/spa/main.htm");
	    InputStream in = u.openStream();
	    in = new BufferedInputStream(in);
	    
	    Reader r = new InputStreamReader(in);
	    OutputStream out =
		new BufferedOutputStream(System.out);
	    
	    int c;
	    while ((c = r.read()) != -1) {
                    out.write((byte) c);
	    }
	    out.flush();
	    out.close();
	    System.out.println("");
	    

        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}

