import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import java.io.File;

public class Valido {

   public static void main(String args[]) {

      if (args.length != 1) {
         System.err.println("Se requiere un nombre de archivo.");
         System.exit(1);
      }

      try {

	  // FileInputStream fis = new FileInputStream(args[0]);
	  File fis = new File(args[0]);
	  DocumentBuilderFactory dbFactory = 
	      DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	  Document doc = dBuilder.parse(fis);
	  doc.getDocumentElement().normalize();
	  System.out.println("File: " + args[0] + " is valid");
      } catch(SAXException se) {
	  System.out.println("File: " + args[0] + " is invalid " 
	      + " SAXException: " + se);
	  System.exit(0);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
