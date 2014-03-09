import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.Vector;
import java.util.Iterator;

class Elemento implements Comparator {

    private int valor;
    private String nombre;

    Elemento(int valor, String nombre) {

	this.valor = valor;
	this.nombre = nombre;
    }

    public int compare(Object o1, Object o2) {
	
	if (o1 instanceof Elemento && 
	    o2 instanceof Elemento) {
	    Elemento e1 = (Elemento) o1;
	    Elemento e2 = (Elemento) o2;
	    return e1.nombre.compareTo(e2.nombre);
	}

	throw new ClassCastException();
    }

    public boolean equals(Object obj) {

	if (obj instanceof Elemento) {

	    Elemento e = (Elemento) obj;

	    if (this.valor == e.valor &&
		this.nombre.equals(e)) {
		return true;
	    }
	}

	return false;
    }

    public String toString() {
	return "" + this.valor + " " + this.nombre;
    }
}

public class Ordenacion {


    public static void main(String args[]) {
	
	List l = new Vector();

	l.add(new Elemento(0, "Patito"));
	l.add(new Elemento(1, "Gatica"));
	l.add(new Elemento(2, "Diana"));
	l.add(new Elemento(3, "Juan"));

	Iterator i = l.iterator();

	while (i.hasNext()) {
	    Elemento e = (Elemento) i.next();
	    System.out.println(e);
	}

	Collections.sort(l, new Elemento(3, "nada"));

	i = l.iterator();

	while (i.hasNext()) {
	    Elemento e = (Elemento) i.next();
	    System.out.println(e);
	}
	
    }

}
