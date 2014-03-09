import java.io.*;

public class Prueba {

	public static boolean isDigit(char c) {

		return Character.getType(c) == Character.DECIMAL_DIGIT_NUMBER;
	}	

	public static int getchar() {

		int val = 0;
		try {
			System.in.mark(1);
			val = System.in.read();
		} catch (IOException ioe) { 
			return -1;
		} 

		return val;
	}

	public static void ungetc() {

		try {
			System.in.reset();
		} catch (IOException ioe) { }

	}

	public static void main(String args[]) {

		System.out.println(""+ System.in.markSupported());
		int val;
		char c;

		while (true) {

			val = getchar();

			System.out.println("val: "+val);
			c = (char) val;
			System.out.println("c: " + c);

			if (isDigit(c))
				System.out.println("Es un digito");
			ungetc();

			val = getchar();

			System.out.println("val: "+val);
			c = (char) val;
			System.out.println("c: " + c);

			if (isDigit(c))
				System.out.println("Es un digito");
		}
	}

}
