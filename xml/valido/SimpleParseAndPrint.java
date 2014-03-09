/**
 *       SimpleParseAndPrint.java
 */
import com.ibm.xml.parser.Parser;
import com.ibm.xml.parser.TXDocument;
import java.io.FileInputStream;
import java.io.PrintWriter;
import org.w3c.dom.Document;

public class SimpleParseAndPrint {
    public static void main(String[] argv) {
        if (argv.length != 1) {
            System.err.println("Require a filename.");
            System.exit(1);
        }
        try {
            // Open specified file.
            FileInputStream is = new FileInputStream(argv[0]);
            // Start to parse
            Parser parser = new Parser(argv[0]);
            Document doc = parser.readStream(is);
            // Error?
            if (parser.getNumberOfErrors() > 0) {
                System.exit(1);                 // If the document has any error,
                // the program is terminated.
            }
            // Print to the standard output
            // in XML format.
            ((TXDocument)doc).print(new PrintWriter(System.out));
            // Codes for process will be here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
