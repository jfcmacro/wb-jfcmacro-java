import java.util.*;

public class Prueba {

    public static void main(String args[]) {
	
	Date d = new Date();

	System.out.println("d" + d);

	try {

		Thread.sleep(10000);
	} catch (InterruptedException ioe) { }

	Date d1 = new Date();

	System.out.println("comparacion: " + (d1.getTime() - d.getTime()));
    }

}
