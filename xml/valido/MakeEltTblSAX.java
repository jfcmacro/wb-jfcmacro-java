import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;
import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;

/**
 * MakeEltTblSAX.java
 */
public class MakeEltTblSAX extends HandlerBase {
    static public void main(String[] argv) {
        if (argv.length != 2) {
            System.err.println("Usage: java MakeEltTblSAX <SAX-class-name> <xml-filename>");
            System.err.println("When you use IBM's XML for Java, com.ibm.xml.parser.SAXDriver is for SAX-class-name");
            System.exit(1);
        }
        try {
            // get class object for SAX Driver
            Class c = Class.forName(argv[0]);
            // create instance of the class
            Parser parser = (Parser)c.newInstance();
            // create document handler, 
            MakeEltTblSAX makehash = new MakeEltTblSAX();
            // and register it
            parser.setDocumentHandler(makehash);

            parser.parse(argv[1]);

            System.out.println(makehash.m_hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    Hashtable m_hash;
    public MakeEltTblSAX() {
        m_hash = new Hashtable();
        m_state = STATE_OTHER;
        m_textbuf = new StringBuffer();
    }

    int m_state;
    static final int STATE_KEY = 0, STATE_VALUE = 1, STATE_OTHER = 2;
    StringBuffer m_textbuf;
    String m_key;

    public void startElement(String name, AttributeList amap) throws SAXException {
        if (name.equals("key")) {
            // store status
            m_state = STATE_KEY;
            m_textbuf.setLength(0);
        } else if (name.equals("value")) {
            // store status
            m_state = STATE_VALUE;
            m_textbuf.setLength(0);
        }
    }

    public void endElement(String name) throws SAXException {
        if (name.equals("key")) {
            m_key = m_textbuf.toString();
            this.m_state = STATE_OTHER;
        } else if (name.equals("value")) {
            m_hash.put(m_key, m_textbuf.toString());
            this.m_state = STATE_OTHER;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (m_state == STATE_KEY || m_state == STATE_VALUE) {
            m_textbuf.append(ch, start, length);
        }
    }

    public void endDocument() throws SAXException {
        m_textbuf = null;
        m_key = null;
    }
}
