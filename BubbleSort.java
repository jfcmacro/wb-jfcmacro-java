import java.util.Scanner;

public class BubbleSort {

    public static int[] readNumbers() {
	final int ARRAYSIZE = 1000;
	int[] numbers = new int[ARRAYSIZE];

	Scanner scan = new Scanner(System.in);
	int i = 0;

	while (scan.hasNextInt()) {

	    numbers[i++] = scan.nextInt();

	    if ((i % ARRAYSIZE) == 0) {
		int[] tmpNumbers = new int[numbers.length + ARRAYSIZE];
		System.arraycopy(numbers, 0, tmpNumbers, 0, numbers.length);
		numbers = tmpNumbers;
	    }
	}

	int[] res = new int[i];
	System.arraycopy(numbers, 0, res, 0, i);

	return res;
    }

    public static void sortNumbers(int []numbers) {
	final int TWO = 2;
	final int ONE = 1;

	for (int i = 0; i < numbers.length - ONE; i++)
	    for (int j = 0; j < numbers.length - ONE - i; j++)
		if (numbers[j] > numbers[j + ONE]) {
		    int temp = numbers[j];
		    numbers[j] = numbers[j + ONE];
		    numbers[j + ONE] = temp;
		}
    }

    public static void printNumbers(int []numbers) {

	for (int i = 0; i < numbers.length; i++)
	    System.out.println(numbers[i]);
    }

    public static void main(String[] args) {
	int[] numbers = readNumbers();

	sortNumbers(numbers);
	printNumbers(numbers);
    }
}
