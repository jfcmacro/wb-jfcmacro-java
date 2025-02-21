import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.File;

public class DOMParserExample {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("books.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Title: " + element.getElementsByTagName("title").item(0).getTextContent());
		    if (element.getElementsByTagName("author").getLength() > 1) {
			System.out.println("Authors");
		    }
		    for (int j = 0; j < element.getElementsByTagName("author").getLength(); j++) {
			System.out.println("Author:  " + element.getElementsByTagName("author").item(j).getTextContent());
		    }
		    System.out.println("Price:  " + element.getElementsByTagName("price").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
