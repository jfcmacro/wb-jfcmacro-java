public class NumeroDeProcesadores {

	public static void main(String args[]) {

		System.out.println("Numero de procesadores disponibles: " +
				Runtime.getRuntime().availableProcessors());
		System.out.println("Memoria libre: " +
				Runtime.getRuntime().freeMemory());
		System.out.println("Memoria total: " +
				Runtime.getRuntime().totalMemory());
		System.out.println("Memoria máxima: " +
				Runtime.getRuntime().maxMemory());
	}

}
