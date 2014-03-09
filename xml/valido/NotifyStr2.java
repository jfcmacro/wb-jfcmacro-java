import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.ParserAdapter;

/**
 * NotifyStr.java
 */
public class NotifyStr2 extends DefaultHandler {

    static public void main(String[] argv) {
      try {

        // get class object for SAX Driver
        Class c = Class.forName(argv[0]);
        // create instance of the class
      XMLReader parser = (XMLReader)c.newInstance();
        // create document handler,
        NotifyStr2 notifyStr = new NotifyStr2();
        // and register it
        parser.setContentHandler(notifyStr);

        parser.parse(argv[1]);

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    public NotifyStr2() {
    }

    public void startDocument() throws SAXException {
      System.out.println("startDocument is called:");
    }

    public void endDocument() throws SAXException {
      System.out.println("endDocument is called:");
    }

    public void startElement(String uri, String name,
			     String qname, Attributes amap) throws SAXException {
      System.out.println("startElement is called: element name=" + name);
      for (int i = 0; i < amap.getLength(); i++) {     
        String attname = amap.getLocalName(i);
        String type = amap.getType(i);     
        String value = amap.getValue(i);
        System.out.println("  attribute name="+attname+" type="+type+" value="+value);
      } 
    }

    public void endElement(String name) throws SAXException {
      System.out.println("endElement is called: " + name);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
      System.out.println("characters is called: " + new String(ch, start, length));
    }
}
