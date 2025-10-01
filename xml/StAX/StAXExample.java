import javax.xml.stream.*;
import java.io.*;

public class StAXExample {
    public static void main(String[] args) throws Exception {
        // Sample XML file
        String xmlFile = "sample.xml";

        // Writing XML using StAX
        writeXML(xmlFile);

        // Reading XML using StAX
        readXML(xmlFile);
    }

    private static void writeXML(String fileName) throws Exception {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(fileWriter);

            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("books");

            writer.writeStartElement("book");
            writer.writeAttribute("id", "1");
            writer.writeStartElement("title");
            writer.writeCharacters("Effective Java");
            writer.writeEndElement();
            writer.writeStartElement("author");
            writer.writeCharacters("Joshua Bloch");
            writer.writeEndElement();
            writer.writeEndElement();

            writer.writeEndElement(); // Close <books>
            writer.writeEndDocument();

            writer.close();
        }

        System.out.println("XML written to " + fileName);
    }

    private static void readXML(String fileName) throws Exception {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileReader fileReader = new FileReader(fileName)) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);

            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    System.out.println("Start Element: " + reader.getLocalName());
                    for (int i = 0; i < reader.getAttributeCount(); i++) {
                        System.out.println("Attribute: " + reader.getAttributeLocalName(i) + " = " + reader.getAttributeValue(i));
                    }
                } else if (event == XMLStreamConstants.CHARACTERS) {
                    if (!reader.isWhiteSpace()) {
                        System.out.println("Text: " + reader.getText());
                    }
                } else if (event == XMLStreamConstants.END_ELEMENT) {
                    System.out.println("End Element: " + reader.getLocalName());
                }
            }

            reader.close();
        }
    }
}
