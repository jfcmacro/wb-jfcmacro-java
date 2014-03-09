import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.FileInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Text;
import org.w3c.dom.Comment;
import org.w3c.dom.ProcessingInstruction;

public class DOMParserPrueba
{
    public static void mostrarNodos(Node nodo) {

	for (Node nodoTmp = nodo; 
	     nodoTmp != null;
	     nodoTmp = nodoTmp.getNextSibling()) {

	    if (nodoTmp instanceof Element) {

		System.out.print(nodoTmp.getNodeName()+ " ");
		NamedNodeMap nnm = nodoTmp.getAttributes();

		if (nnm != null && nnm.getLength() > 0)
		    System.out.print("Attributos:");

		for (int i = 0; i < nnm.getLength(); i++) {
		    System.out.print(" " +
				       nnm.item(i).getNodeName() +
				       "=" + nnm.item(i).getNodeValue());
		    
		}

		System.out.println("");
	    }
	    
	    if (nodoTmp instanceof Text) {
		System.out.println(nodoTmp.getNodeValue());
	    }

	    if (nodoTmp instanceof Comment) {
		System.out.println("Comentario: " + nodoTmp.getNodeValue());
	    }

	    if (nodoTmp instanceof ProcessingInstruction) {
		System.out.println("Instruccion de procesamiento: " + 
				   nodoTmp.getNodeName() + "->" +
				   nodoTmp.getNodeValue());
	    }

	    if (nodoTmp.getFirstChild() != null) 
		mostrarNodos(nodoTmp.getFirstChild());
	    
	}	    
    }

    public static void main(String args[]) {

	if (args.length != 1) {
	    System.out.println("Se requiere al menos un archivo");
	    System.exit(1);
	}

	try {
	   
	    FileInputStream fis = new FileInputStream(args[0]);
	    
	    DocumentBuilder db = DocumentBuilderFactory.
		newInstance().newDocumentBuilder();
	    Document doc = db.parse(fis);

	    // Examina los elementos del nodo raiz

	    Element  e = doc.getDocumentElement();
	    
// 	    System.out.println(e.getNodeName());
	    
	    mostrarNodos(e);
	    

	} catch (Exception e) {
	    System.out.println("Excepcion " + e);
	    System.exit(1);
	}

	System.exit(0);
    }
}
