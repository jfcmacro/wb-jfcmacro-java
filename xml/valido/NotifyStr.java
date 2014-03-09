import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.Parser;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * NotifyStr.java
 */
public class NotifyStr extends HandlerBase {
    static public void main(String[] argv) {
      try {

        // Obtiene una objeto de clase para el
	// controlador de SAX
        Class c = Class.forName(argv[0]);
        // Crea una instacia de clase
        Parser parser = (Parser)c.newInstance();
        // Crea un manejador de documento
        NotifyStr notifyStr = new NotifyStr();
        // Y lo registra
        parser.setDocumentHandler(notifyStr);

        parser.parse(argv[1]);

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    public NotifyStr() {
    }

    public void startDocument() throws SAXException {
      System.out.println("startDocument es llamado: ");
    }

    public void endDocument() throws SAXException {
      System.out.println("endDocument es llamado");
    }

    public void startElement(String name, AttributeList amap) throws SAXException {
      System.out.println("startElement: element name=" + name);
      for (int i = 0; i < amap.getLength(); i++) {     
        String attname = amap.getName(i);
        String type = amap.getType(i);     
        String value = amap.getValue(i);
        System.out.println("  nombre attributo="+attname+" tipo="+type+" valor="+value);
      } 
    }

    public void endElement(String name) throws SAXException {
      System.out.println("endElement es llamado: " + name);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
      System.out.println("characters es llamado: " + new String(ch, start, length));
    }
}
