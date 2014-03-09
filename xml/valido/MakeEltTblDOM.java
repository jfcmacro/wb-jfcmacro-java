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
 * MakeEltTblDOM.java
 **/
public class MakeEltTblDOM {

    static public void main(String[] argv) {
        if (argv.length != 1) {
            System.err.println("Missing filename.");
            System.exit(1);
        }
        try {
            // Open specified file
            InputStream is = new FileInputStream(argv[0]);

            // Start parsing
            Parser parser = new Parser(argv[0]);   // @XML4J
            Document doc = parser.readStream(is);  // @XML4J

            // Check if there is errors
            if (parser.getNumberOfErrors() > 0) {  // @XML4J
                System.exit(1);
            }
            // Document is well-formed

            // Create hashtable for string key-value pairs
            Hashtable hash = new Hashtable();

            String key = null, value = null;
            
            // Traverse all the children of the root element
            for (Node kvchild = doc.getDocumentElement().getFirstChild();
                kvchild != null;
                kvchild = kvchild.getNextSibling()) {
                
                // When child is an element
                if (kvchild instanceof Element) {
                    // If tag name is "key", store its content in vkey
                    if (kvchild.getNodeName().equals("key")) {
                        key = makeChildrenText(kvchild);

                    // If tag name is "value"
                    } else if (kvchild.getNodeName().equals("value")) {
                        
                        // Extract the text content from the child
                        value = makeChildrenText(kvchild);
                        // Check key is specified and
                        // store the key-value pair int the hashtable
                        if (key != null) {
                            hash.put(key, value);
                            key = null;
                        }
                    }
                }
            }
            // Display the hashtable
            System.out.println(hash);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String makeChildrenText (Node node){
       // Create a StringBuffer to store the result.
       // StringBuffer is more efficient than String
       StringBuffer buffer = new StringBuffer();
       return makeChildrenText1 (node, buffer);
    }

    private static String makeChildrenText1 (Node node, StringBuffer buffer){

       // Visit all the child nodes
       for (Node ch = node.getFirstChild();
             ch != null;
             ch = ch.getNextSibling()) {
            // Recursively call if the child may have children
            if (ch instanceof Element || ch instanceof EntityReference) {
                buffer.append(makeChildrenText(ch));
            // If the child is a text, append it to the result buffer
            } else if (ch instanceof Text) {
                buffer.append(ch.getNodeValue());
            }
       }

        return buffer.toString();
    }
}
