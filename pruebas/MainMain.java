
public class MainMain {

	static int valor = 10;

	public static void main(String args[]) {

		System.out.println("Valor: " + valor);

		if (valor > 0) {
			valor--;

			String []newArgs = null;
			MainMain.main(newArgs);
		}

	}
}
