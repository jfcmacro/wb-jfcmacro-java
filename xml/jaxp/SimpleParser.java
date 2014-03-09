
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.FileInputStream;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SimpleParser extends DefaultHandler
{
    
    public SimpleParser() {
    }

    public void startDocument() 
	throws SAXException {
	System.out.println("Inicio el documento");
    }

    public void endDocument() {
	System.out.println("Termino el documento");
    }

    public void startElement(String uri, 
			     String localName, 
			     String qName, 
			     Attributes attributes) {
	System.out.println("Uri: " + uri + " localName: " +
			   " qName: " + qName);

	int length = attributes.getLength();

	for (int i = 0; i < length; i++) {
	    System.out.println("Type: " + attributes.getType(i) +
			       " Value: " + attributes.getValue(i));
	}
    }

    public void endElement(String uri, String localName, String qName) {
	System.out.println("Uri: " + uri + " localName: " + localName +
			   " qName: " + qName);
    }

    public void characters(char[] ch, int start, int length)
	throws SAXException {
	String s = new String(ch, start, length);
	System.out.println(s);
    }

    public static void main(String args[]) {

	if (args.length != 1) {
	    System.err.println("Se requiere el nombre de al menos un archivo");
	    System.exit(1);
	}

	try {
	    FileInputStream fis = new FileInputStream("Maquina.xml");
	    SAXParserFactory spf = SAXParserFactory.newInstance();
	    SAXParser saxParser = spf.newSAXParser();
	    DefaultHandler dh = new SimpleParser();

	    saxParser.parse(fis, dh);
	  
	} catch (org.xml.sax.SAXException saxe) {
	    System.err.println(saxe);
	    System.exit(1);
	} catch (Exception e) {
	    System.err.println(e);
	    System.exit(1);
	}
     
	System.exit(0);
    }
}
