
public class Compare {

	public static void main(String []args) {

		String valor = "Hola ";

		String valor1 = "Hola1";


		System.out.println(" Hola contra Hola1 " 
			+ (valor.compareTo(valor1)));
		System.out.println(" Hola1 contra Hola " 
			+ (valor1.compareTo(valor)));
		System.out.println(" Hola contra Hola " 
			+ (valor.compareTo(valor)));


	}

}
