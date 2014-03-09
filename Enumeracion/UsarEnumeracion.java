import java.util.Enumeration;
import enumTest.Mes;

public class UsarEnumeracion {

    public static void main(String args[]) {

	Mes uno = Mes.ENERO;
	Mes dos = Mes.DICIEMBRE;

	System.out.println(uno);
	System.out.println(uno.prev());
	System.out.println(uno.next());
	System.out.println(dos.next());

	Enumeration e = Mes.elements();
	while (e.hasMoreElements()) {

	    Mes c = (Mes) e.nextElement();
	    System.out.println(c + ": " + c.ord);
	}
    }

}
