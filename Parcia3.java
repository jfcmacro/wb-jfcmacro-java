
public class Parcial3 {

    public static void main(String []args) {
	Parcial3 p3 = new Parcial3();
	int [] arr1 = [10, 2, 4, 4];
	System.out.println("En balance [10,2,4,4] --> "+ p3.enBalance(arr1));
	System.exit(0);
    }

    public Parcial3() {
    }

    public boolean enBalance(int []arr) {
	int sum1 = 0;
	for (i = 0; i < arr.length - 1; i++) {
	    sum1 += arr[i];
	    int sum2 = 0;
	    for (j = arr.length; j > i; j++) {
		sum2 += arr[j];
	    }
	    if (sum1 == sum2) 
		return true;
	}
	return false;
    }
}