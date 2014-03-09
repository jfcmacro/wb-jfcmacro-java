import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainExprSAX {

    public static void usage() {
	System.err.println("Uso MainExprSAX <expr>");
	System.exit(1);
    }

    public static void main(String[] args) {

	if (args.length != 1) {
	    usage();
	}

	try { 

	    XMLReader reader = XMLReaderFactory.createXMLReader();
	    ExprSAXHandler esh = new ExprSAXHandler();
	    reader.setContentHandler(esh);
	    reader.setErrorHandler(esh);

	    FileReader r = new FileReader(args[0]);
	    reader.parse(new InputSource(r));

	    for (String s : esh.getCollectedIds()) {
		System.out.println(s);
	    }

	} catch (SAXException e) {
	    System.err.println("Error while processing document" + e);
	    System.err.println(e.getMessage());
	    System.exit(1);
	} catch (FileNotFoundException fnfe) {
	    System.err.println(fnfe.getMessage());
	    System.exit(1);
	} catch (IOException ioe) {
	    System.err.println(ioe.getMessage());
	    System.exit(1);
	}
    }
}