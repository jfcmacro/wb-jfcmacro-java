// ElementoEntero.java

public class ElementoEntero extends Elemento {

    private int valor;

    // Constructores 
    public ElementoEntero() {
	this.valor = 0;
    }

    public ElementoEntero(int valor) {
	this.valor = valor;
    }

    // Implementación de métodos abstractos

    public boolean menorQue(Elemento e) {
	if (!(e instanceof ElementoEntero)) 
	    return false;
	
	if (this.valor < ((ElementoEntero) e).valor) 
	    return true;
	
	return false;
    }

    public boolean menorOIgualQue(Elemento e) {
	if (!(e instanceof ElementoEntero)) 
	    return false;
	
	if (this.valor <= ((ElementoEntero) e).valor) 
	    return true;
	
	return false;
    }

    public boolean mayorQue(Elemento e) {
	if (!(e instanceof ElementoEntero)) 
	    return false;
	
	if (this.valor > ((ElementoEntero) e).valor) 
	    return true;
	
	return false;
    }

    public boolean mayorOIgualQue(Elemento e) {
	if (!(e instanceof ElementoEntero)) 
	    return false;
	
	if (this.valor >= ((ElementoEntero) e).valor) 
	    return true;
	
	return false;
    }

    public boolean igual(Elemento e) {
	if (!(e instanceof ElementoEntero))
	    return false;
	
	if (this.valor == ((ElementoEntero) e).valor) 
	    return true;
	
	return false;
    }

    public int obtenerValor() {
	return valor;
    }

    public void establecerValor(int valor) {
	this.valor = valor;
    }
    
    public String toString() {
	return "" + valor;
    }
}
