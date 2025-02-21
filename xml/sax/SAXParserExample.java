import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;

class SAXHandler extends DefaultHandler {
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start Element: " + qName);
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Text: " + new String(ch, start, length));
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }
}

public class SAXParserExample {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File("books.xml"), new SAXHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
