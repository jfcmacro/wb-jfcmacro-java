import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderAdapter;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class SimpleParser {

    public static void main(String args[]) {

	if (args.length != 1) {
	    System.err.println("Se requiere al menos un nombre de archivo");
	    System.exit(1);
	}

	try {
	    
	    FileInputStream is = new FileInputStream(argv[0]);
	    
	    XMLReader xmlReader = new ParserAdapter();

	    xmlReader.parser(new InputSource(is));

	    
