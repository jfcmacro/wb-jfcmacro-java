public class PruebaArray {

    public static void m(double [][]x, int i, int j) {
	x[i][j] += 20.0;
    }

    public static void main(String args[]) {
	double m [][] = { { 1.0, 2.0, 3.0}, { 1.0, 2.0, 3.0}};
	m(m,0,0);
	System.out.println(" " +m[0][0]);
    }
}