// Main2.java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main2 {

    public static void main(String[] args) {

	Pila p = new Pila();

	ElementoFlotante ee;

	try {
	    BufferedReader br = 
		new BufferedReader(new InputStreamReader(System.in));
	    
	    for (int i = 0; i < 10; i++) {
		String linea = br.readLine();
		float valor = Float.parseFloat(linea);
		p.push(new ElementoFlotante(valor));
	    }

	    while ((ee = (ElementoFlotante) p.pop()) != null) {
		Elemento ee1 = ee;
		Elemento ee2 = (ElementoFlotante) p.pop();
		if (ee2 == null) {
		    System.err.println("No hay un numero par de elementos");
		    System.exit(1);
		}

		if (ee1.mayorQue(ee2)) {
		    System.out.println("Valor   " + ee1 + 
				       " mayor que " + ee2);
		}
		else {
		    System.out.println("Valor " + ee1 +
				       " no es mayor que " + 
				       ee2);
		}
	    }
	    
	} catch (IOException ioe) {
	    System.err.println("Error: " + ioe);
	    System.exit(1);
	}
    }
}

	
