
public class Quiz {

	public static int valor = 16;
	public static final int MASCARA = 0x0F0;


	public static void main(String []args) {

		valor <<= 2;

		valor &= MASCARA;

		System.out.println("valor: " + valor);

	}	
}
