import java.util.Enumeration;

public class Propiedades {

    public static void main(String args[]) {

	Enumeration e = System.getProperties().propertyNames();

	while (e.hasMoreElements()) {

	    System.out.println(e.nextElement());
	}
    }
}
