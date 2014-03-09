// Elemento.java

public abstract class Elemento {

    protected Elemento sig;

    // Métodos abstractos

    public abstract boolean menorQue(Elemento e);
    public abstract boolean menorOIgualQue(Elemento e);
    public abstract boolean mayorQue(Elemento e);
    public abstract boolean mayorOIgualQue(Elemento e);
    public abstract boolean igual(Elemento e);
    
    // Constructores
    
    public Elemento() {
	this.sig = null;
    }

    public Elemento(Elemento sig) {
	this.sig = sig;
    }

    // Métodos miembro

    public void establecerSiguiente(Elemento sig) {
	this.sig = sig;
    }

    public Elemento obtenerSiguiente() {
	return this.sig;
    }
}
