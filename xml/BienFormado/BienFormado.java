import org.w3c.dom.Document;
import com.ibm.xml.parser.*;
import java.io.FileInputStream;

public class BienFormado {

    public static void main(String args[]) {
	
	if (args.length != 1) {
	    System.err.println("Se requiere un nombre de archivo");
	    System.exit(1);
	}

	try {
	    
	    FileInputStream fis = new FileInputStream(args[0]);

	    Parser parser = new Parser(args[0]);

	    Document doc = parser.readStream(fis);
	    
	    if (parser.getNumberOfErrors() > 0) {
		System.exit(1);
	    }

	} catch (Exception e) {

	    e.printStackTrace();
	}
    }
}
