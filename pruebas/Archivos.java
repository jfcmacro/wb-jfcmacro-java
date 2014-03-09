import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Archivos {
    
    public static void main(String []args) {
	
	try {
	    BufferedWriter bw = 
		new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./miarchivo", true)));
	    
	    String hola = "hola al final";
	    
	    bw.write(hola, 0, hola.length());
	    
	    // bw.close();
	    
	} catch (Exception e) {
	    System.err.println(""+e);
	    System.exit(1);
	}
    }
}
		

		
