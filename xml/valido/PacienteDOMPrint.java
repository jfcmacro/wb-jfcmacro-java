import com.ibm.xml.parser.Parser;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Hashtable;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * PacienteDOMPrint.java
 * 
 * Proposito: Mostrar los componentes de una jerarquia DOM
 **/
public class PacienteDOMPrint {

    static public void main(String[] argv) {
       
        // Verifica argumentos
        if (argv.length != 1) {
            System.err.println("Falta nombre de archivo");
            System.exit(1);
        }

        // Procesa
        try {
            // Abre el archivo especificado
            InputStream fis = new FileInputStream(argv[0]);

            // Inicia la evaluacion
            Parser parser = new Parser(argv[0]);   // @XML4J
            Document doc = parser.readStream(fis);  // @XML4J

            // Evalua si hay errores
            if (parser.getNumberOfErrors() > 0) {  // @XML4J
                System.exit(1);
            }
            // El documento esta bien formado

            String key = null, value = null;
            
            // Recorre todos los hijos del archivo
            for (Node kvchild = doc.getDocumentElement().getFirstChild();
                kvchild != null;
                kvchild = kvchild.getNextSibling()) {
                
                System.out.println(kvchild.getClass());
	        
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
