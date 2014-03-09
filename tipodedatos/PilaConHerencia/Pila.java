// Pila.java

public class Pila {

    public Pila() {
	cabeza = null;
	nElementos = 0;
    }

    private Elemento cabeza;
    private int nElementos;

    public void push(Elemento e) {
	e.establecerSiguiente(cabeza);
	cabeza = e;
	nElementos++;
    }

    public Elemento pop() {
	
	if (cabeza == null)
	    return null;

	Elemento e = cabeza;

	cabeza = cabeza.obtenerSiguiente();
	e.establecerSiguiente(null);
	nElementos--;
	return e;
    }

    public int totalElementos() {
	return nElementos;
    }
}
