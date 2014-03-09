import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LectorSAX  {

    public void lee(String url){
       try{
	   SAXParserFactory spf=SAXParserFactory.newInstance();
	   SAXParser sp = spf.newSAXParser();
	   sp.parse(url, new LibraryXMLReader() );
       }catch(ParserConfigurationException e){
	   System.err.println("error de  parseo");
       }catch(SAXException e2){
	   System.err.println("error de  sax : " + e2.getStackTrace());
       } catch (IOException e3) {
	   // TODO Auto-generated catch block
	   System.err.println("error de  io : " + e3.getMessage() );
        }

    }

    public static void main(String[] args){
	LectorSAX lector = new LectorSAX();
	lector.	lee(args[0]);
    }
    //---------------------------------------------------------------------------------
    private class LibraryXMLReader
	extends DefaultHandler {

	String contenido="";  // cadena para almacenar el contenido de un tag

	public void startDocument() throws SAXException{
	    System.out.println("Estoy al principio del documento");

  	}
	public void endDocument()throws SAXException{
	    System.out.println("Estoy al final del documento");
  	}

     	/* Esta funcion el llamada cuando se produce el evento
    	 * de(non-Javadoc)
    	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
    	 */
    	public void startElement(String uri, String localName, String qName, Attributes attributes) {
	    System.out.println("he encontrado una nueva etiqueta :" + qName);
        }

    	/* Esta funcion es llamada cuando ve el contenido de un tag
    	 * (non-Javadoc)
    	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
    	 */
        public void characters(char buf[], int offset, int len)
	    throws SAXException
        {
	    contenido = new String(buf, offset, len);
        }
        /* y esta al llegar al final
         * (non-Javadoc)
         * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
         */
        public void endElement(String uri, String localName, String qName) {
	    System.out.println("he leido la  etiqueta : " + qName + " y su contenido es : " + contenido);
	}
    }
}