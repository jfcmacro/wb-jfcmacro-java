public class InsertionSort {
    
    public static <T extends Comparable<T>> void insertionSort(T[] vector) {
	insertionSort(vector, vector.length);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] vector, int length) {
	for (int j = 1; j < length; j++) {
	    T key = vector[j];

	    int i = j - 1;
	    for (; i >= 0 && vector[i].compareTo(key) > 0; i--)
		vector[i + 1] = vector[i];
	    vector[i + 1] = key;
	}
    }

    public static <T> void printVector(T[] vector) {
	printVector(vector, vector.length);
    }

    public static <T> void printVector(T[] vector, int length) {
	for (int i = 0; i < length; i++) {
	    System.out.print(vector[i]);
	    if (i < (length - 1))
		System.out.print(',');
	}
	System.out.println("");
    }

    public static void main(String args[]) {

	Float vector1[] = { 9.3f, 8.9f, 6.2f, 4.2f, 4.1f, 3.3f };
	Integer  vector2[] = { 12, 34, 9, 1, 36 };

	printVector(vector1);
	insertionSort(vector1);
	printVector(vector1);

	printVector(vector2);
	insertionSort(vector2);
	printVector(vector2);
    }
}
