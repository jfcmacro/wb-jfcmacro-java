package algorithms.sedgewick.chap01;

import edu.princeton.cs.stdlib.StdIn;

public class TestJava {
    public static int gcd(int p, int q) {
	if (q == 0) return p;
	int r = p % q;
	return gcd(q, r);
    }

    public static void main(String []args) {
	int a = StdIn.readInt();
	int b = StdIn.readInt();
	System.out.println("The gcd(" + a + "," + b + ")=" + gcd(a,b));
	System.exit(0);
    }
}
