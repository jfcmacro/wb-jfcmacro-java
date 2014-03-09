
public class Parcial3 {

    public static void main(String []args) {
	Parcial3 p3 = new Parcial3();
	int [] arr1 = {10, 2, 4, 4};
	System.out.println("En balance [10,2,4,4] --> "+ p3.enBalance(arr1));
	arr1 = new int[] {4, 4, 2, 10};
	System.out.println("En balance [4,4,2,10] --> " +p3.enBalance(arr1));
	System.out.println("Max secuencia \"Hola\" --> " + p3.maxSec("Hola"));
	System.out.println("Max secuencia \"ooolllaaa\" --> " + p3.maxSec("ooolllaaa"));
	System.out.println("Max secuencia \"xyzz\" --> " + p3.maxSec("xyzz"));
	System.exit(0);
    }

    public Parcial3() {
    }

    public boolean enBalance(int []arr) {
	int sum1 = 0;
	for (int i = 0; i < arr.length; i++) {
	    sum1 += arr[i];
	    int sum2 = 0;
	    for (int j = (arr.length - 1); j > i; j--) {
		sum2 += arr[j];
	    }
	    if (sum1 == sum2) 
		return true;
	}
	return false;
    }

    public int maxSec(String str) {
	int max = 0, sec = 0;
        boolean encontrar = false;
        for (int i = 0; i < str.length() - 1; i++) {

	    if (str.charAt(i) == str.charAt(i+1)) {
		sec += !encontrar ? 2 : 1;
		encontrar = true;
	    }
	    else {
		if (encontrar) {
		    if (max < sec) {
			max = sec;
		    }
		}
		sec = 0;
		encontrar = false;
	    }
	}
	return max;
    }

    public int contarYZ(String str) {
	int ends = 0;
	java.util.StringTokenizer st = new java.util.StringTokenizer(str);
	while (st.hasMoreTokens()) {
	    String s = st.nextToken();
	    ends += s.endsWith("y") || s.endsWith("z") ? 1 : 0;
	}
	return ends;
    }
}