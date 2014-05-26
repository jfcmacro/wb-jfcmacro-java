/*
 * An example of how to use Scanner in order to process an input file
 * 
 * Using: java PruebaJavaRead Entrada.txt
 */

import java.util.*;

public class PruebaJavaRead {

    public static void main(String args[]) {
	Scanner scan = new Scanner(System.in);
	int nEntry = scan.nextInt();
	scan.nextLine();
	for (int i = 0; i < nEntry; i++) {
	    String s = scan.nextLine();
	    StringTokenizer st = new StringTokenizer(s, ",");
	    String tarea = st.nextToken();
	    String tipo = st.nextToken();
	    int valor = Integer.parseInt(st.nextToken());
	    System.out.println("Tarea: " + tarea + " tipo: " + tipo +
			       " valor: " + valor);
	}
	while (scan.hasNext()) {
	    String s = scan.nextLine();
	    System.out.println(s);
	}
    }
}
