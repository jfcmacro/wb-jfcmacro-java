import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.IOException;

public class MainExprDOM {

    public static void usage() {
	System.err.println("Uso MainExprSAX <expr>");
	System.exit(1);
    }

    public static void main(String[] args) {
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	try {
	    dbf.setIgnoringElementContentWhitespace(true);
	    DocumentBuilder parser = dbf.newDocumentBuilder();
	    Document doc = parser.parse(args[0]);
	} catch (SAXException se) {

	    System.err.println(se.getMessage());
	    System.exit(1);
	} catch (IOException ioe) {

	    System.err.println(ioe.getMessage());
	    System.exit(1);
	} catch (IllegalArgumentException iae) {

	    System.err.println(iae.getMessage());
	    System.exit(1);
	} catch (ParserConfigurationException pce) {

	    System.err.println(pce.getMessage());
	    System.exit(1);
	}
    }
}