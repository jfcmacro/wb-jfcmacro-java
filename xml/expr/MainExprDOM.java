import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.IOException;

public class MainExprDOM {

    public static void usage() {
	System.err.println("Uso MainExprSAX <expr>");
	System.exit(1);
    }

    public static void main(String[] args) {
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	try {
	    dbf.setIgnoringElementContentWhitespace(true);
	    DocumentBuilder parser = dbf.newDocumentBuilder();
	    Document doc = parser.parse(args[0]);
	    System.out.println("Resultado: " + getElement(doc));
	    // getElement2(doc);
	} catch (SAXException se) {

	    System.err.println(se.getMessage());
	    System.exit(1);
	} catch (IOException ioe) {

	    System.err.println(ioe.getMessage());
	    System.exit(1);
	} catch (IllegalArgumentException iae) {

	    System.err.println(iae.getMessage());
	    System.exit(1);
	} catch (ParserConfigurationException pce) {

	    System.err.println(pce.getMessage());
	    System.exit(1);
	}
    }

    public static int getElement(Node node) {

	if (node != null) {
	    System.out.println("Node: " + node.getNodeName());
	}

	if (node == null) { return 0; }
	if (node.getNodeName().equals("add")) {
	    // We asume that there is only two children.
	    NodeList children = node.getChildNodes();
	    Node left = children.item(0);
	    Node right = children.item(1);
	    return getElement(left) + getElement(right);
	}
	if (node.getNodeName().equals("sub")) {
	    // We asume that there is only two children.
	    NodeList children = node.getChildNodes();
	    Node left = children.item(0);
	    Node right = children.item(1);
	    return getElement(left) - getElement(right);
	}
	if (node.getNodeName().equals("mul")) {
	    // We asume that there is only two children.
	    NodeList children = node.getChildNodes();
	    Node left = children.item(0);
	    Node right = children.item(1);
	    return getElement(left) * getElement(right);
	}
	if (node.getNodeName().equals("div")) {
	    // We asume that there is only two children.
	    NodeList children = node.getChildNodes();
	    Node left = children.item(0);
	    Node right = children.item(1);
	    return getElement(left) / getElement(right);
	}
	if (node.getNodeName().equals("NUMBER")) {
	    // We asume that there is only one child.
	    NodeList children = node.getChildNodes();
	    Node value = children.item(0);
	    System.out.println("value: " + value.getTextContent());
	    return (new Integer(value.getTextContent().trim())).intValue();
	}
	if (node.getNodeName().equals("ID")) {
	    return 0;
	}
	if (node.getNodeName().equals("#document")) {
	    // NodeList children = node.getChildNodes();
	    return getElement(node.getFirstChild());

	}
	if (node.getNodeName().equals("expr")) {
	    // NodeList children = node.getChildNodes();
	    return getElement(node.getFirstChild());
	}
	System.out.println("Not reach " + node.getNodeName());
	return 0;
    }

    public static void getElement2(Node node) {
	if (node != null) {
	    System.out.println("Node: " + node.getNodeName());
	    if (node.getNodeName().equals("#text")) {
		System.out.println(node.getTextContent());
	    }
	}
	if (node == null) {
	    return;
	}
	NodeList children = node.getChildNodes();
	for (int i = 0; i < children.getLength(); i++) {
	    getElement2(children.item(i));
	}
    }

}