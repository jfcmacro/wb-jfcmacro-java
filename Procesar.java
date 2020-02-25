import java.util.Scanner;

public class Procesar {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	String s = null;

	do {
	    System.out.println("Entrar: ");
	    s = scan.nextLine();
	    switch (s) {
	    case "uno":
		System.out.println("uno");
		break;
	    case "dos":
		System.out.println("prueba");
		break;
	    case "salir":
		break;
	    }
	} while (!s.equals("salir"));
    }
}
