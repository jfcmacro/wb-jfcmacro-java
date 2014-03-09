
public class Fibonacci {

	public static int Fibonacci(int value) {

		if (value == 0) {
		
			return 0;

		}

		if (value == 1) {

			return 1;
		}

	
		return Fibonacci(value - 1) + Fibonacci(value - 2);
	}

	public static void main(String []args) {

		for (int i = 0; i < 10; i++) {
		
			System.out.println("Fibonacci(" + i + 
					   ")=" + Fibonacci(i));
		}

	}
}
