// PilaEntero.java

class ElementoEntero {
    int valor;
    ElementoEntero sig;
    ElementoEntero(int valor, ElementoEntero sig) {
	this.valor = valor;
	this.sig = sig;
    }
    ElementoEntero(int valor) {
	this.valor = valor;
	this.sig = null;
    }
}

public class PilaEntero {

    public class ENOMEMORY extends Exception { }
    public class EUNDERFLOW extends Exception { }

    private ElementoEntero cabeza = null;
    private int nElementos = 0;

    public PilaEntero() {
	cabeza = null;
	nElementos = 0;
    }
    
    public void  push(int valor)	throws ENOMEMORY {
	ElementoEntero ee = new ElementoEntero(valor, cabeza);
	
	if (ee == null) 
	    throw new ENOMEMORY();

	this.cabeza = ee;
	this.nElementos = 0;
    }

    public int pop() 
	throws EUNDERFLOW {
	
	if (cabeza == null)
	    throw new EUNDERFLOW();
	
	ElementoEntero ee = cabeza;
	int valor = ee.valor;

	this.cabeza = ee.sig;
	this.nElementos = 0;
	return valor;
    }

    public int tamano() {
	return nElementos;
    }
	
} 
