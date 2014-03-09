// ArrayCopyTest

public class ArrayCopyTest {

    public static void main(String[] args) {

	int []vector = new int[12];

	for (int i = 0; i < vector.length; i++) 
	    vector[i] = i * 2;

	int []vector2 = new int[24];

	System.arraycopy(vector, 0, vector2, 0, vector.length);

	for (int i = 0; i < vector.length; i++) {
	    System.out.println(" " + vector2[i]);
	}
    }
}


