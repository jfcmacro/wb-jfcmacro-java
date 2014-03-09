import java.util.Stack;

public class Conversion {

    public static void main(String []args) {

	int numero = 1030;
	int residuo;
	Stack pila = new Stack();

	while (numero != 0) {
	    residuo = numero % 10;
	    byte zero = '0';
	    char valor;
	    valor = (char) (zero + residuo);
	    pila.push(new Character(valor));
	    System.out.println(valor);
	    numero = numero / 10;
	}

	while (!pila.empty()) {
	    System.out.print(pila.pop());
	}
	
    }

}
