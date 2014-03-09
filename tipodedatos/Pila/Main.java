// Main.java

public class Main {
    
    public static void main(String []args) {
	
	PilaEntero pila = new PilaEntero();
	
	try {
	    pila.push(50);
	    pila.push(51);
	    pila.push(41);
	    
	    System.out.println("Valor: " + pila.pop());
	    System.out.println("Valor: " + pila.pop());
	    System.out.println("Valor: " + pila.pop());
	    System.out.println("Valor: " + pila.pop());

	}
	catch (PilaEntero.ENOMEMORY e1) {
	    System.out.println("No hay memoria");
	}
	catch (PilaEntero.EUNDERFLOW e2) {
	    System.out.println("Pila vacia");
	}
	System.exit(0);
	    
    }
}
