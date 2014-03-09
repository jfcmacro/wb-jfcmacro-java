
public class Parametros {

    int valor  = 10;

    public Parametros() {
    }

    public int sumar(int valor1, int valor2) {
	return valor1 + valor2;
    }

    public static void main(String []args) {

	Parametros p = new Parametros();

	int val1 = 10;
	int val2 = 20;

	System.out.println(" " + p.sumar(val1, val2));
	System.out.println(" " + p.sumar(10, 20));

	System.out.println(" " + p.sumar(22, 30));


    }
}
