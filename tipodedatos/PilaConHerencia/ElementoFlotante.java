// ElementoFlotante.java

public class ElementoFlotante extends Elemento {

    private float valor;

    // Constructores 
    public ElementoFlotante() {
	this.valor = 0;
    }

    public ElementoFlotante(float valor) {
	this.valor = valor;
    }

    // Implementación de métodos abstractos

    public boolean menorQue(Elemento e) {
	if (!(e instanceof ElementoFlotante)) 
	    return false;
	
	if (this.valor < ((ElementoFlotante) e).valor) 
	    return true;
	
	return false;
    }

    public boolean menorOIgualQue(Elemento e) {
	if (!(e instanceof ElementoFlotante)) 
	    return false;
	
	if (this.valor <= ((ElementoFlotante) e).valor) 
	    return true;
	
	return false;
    }

    public boolean mayorQue(Elemento e) {
	if (!(e instanceof ElementoFlotante)) 
	    return false;
	
	if (this.valor > ((ElementoFlotante) e).valor) 
	    return true;
	
	return false;
    }

    public boolean mayorOIgualQue(Elemento e) {
	if (!(e instanceof ElementoFlotante)) 
	    return false;
	
	if (this.valor >= ((ElementoFlotante) e).valor) 
	    return true;
	
	return false;
    }

    public boolean igual(Elemento e) {
	if (!(e instanceof ElementoFlotante))
	    return false;
	
	if (this.valor == ((ElementoFlotante) e).valor) 
	    return true;
	
	return false;
    }

    public float obtenerValor() {
	return valor;
    }

    public void establecerValor(int valor) {
	this.valor = valor;
    }

    public String toString() {
	return "" + valor;
    }
}
