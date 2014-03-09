import com.ibm.xml.parser.TXDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ProcessingInstruction;
import java.io.PrintWriter;

public class HacerDocumentoConFabrica {

    public static void main(String args[]) {

	try {

	    // Crea un objeto Documento
	    Document doc = (Document)Class.forName
		("com.ibm.xml.parser.TXDocument").newInstance();

	    // Convierte a "persona" en el elemento raiz
	    Element root = doc.createElement("persona");

	    // Crea el elemento "nombre" y lo adiciona
	    Element item = doc.createElement("nombre");
	    item.appendChild(doc.createTextNode("J.M Burns"));
	    root.appendChild(item);
	    
	    // Genera el comando y la instruccion de procesamiento
	    root.appendChild(doc.createComment
			     ("Procesando instruccion para la aplicacion"));
	    root.appendChild(doc.createProcessingInstruction("parser", 
							    "ignoreNextLine"));
	    // Crea el elemento "edad" y lo adicion
	    item = doc.createElement("edad");
	    item.appendChild(doc.createTextNode("35"));
	    root.appendChild(item);
	    
	    // Crea el elemento "email" y lo añade
	    item = doc.createElement("url");
	    item.setAttribute("href", "http://www.plantanuclearspringfield.com/~jmburns");
	    root.appendChild(item);
	    
	    // Ahora, el elemento raiz tiene asignado un nombre, edad,
	    // email y url
	    doc.appendChild(root);
	    
	    // Muestra el documento XML
	    ((TXDocument)doc).setVersion("1.0");
	    ((TXDocument)doc).printWithFormat(new PrintWriter(System.out));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}


