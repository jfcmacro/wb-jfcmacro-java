import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;

class SAXHandler extends DefaultHandler {
    public void startDocument() {
	System.out.println("Start document");
    }
    
    public void startElement(String uri,
			     String localName,
			     String qName,
			     Attributes attributes) {
	System.out.printf("Uri: %s localName: %s attributes: %s%n",
			  uri, localName, attributes);
        System.out.println("Start Element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Text: " + new String(ch, start, length));
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    public void endDocument() {
	System.out.println("End document");
    }
}

public class SAXParserExample {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File("books.xml"), new SAXHandler());
	    Schema sch = saxParser.getSchema();
	    System.out.printf("Schema: %s%n", sch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
