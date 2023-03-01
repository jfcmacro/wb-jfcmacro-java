public class IsLessRel {
    public static <T extends Comparable<T>> boolean isLess(T[] x, T[] y) {
	int i;
	for (i = 0; i < x.length && i < y.length && x[i].compareTo(y[i]) == 0; i++);
	return i < x.length && i < y.length && x[i].compareTo(y[i])<0;
    }

    public static boolean isLessInt(int[] x, int[] y) {
	int i;
	for (i = 0; i < x.length && i < y.length && x[i] == y[i]; i++);
	return i < x.length && i < y.length && x[i] < y[i];
    }

    public static boolean isLessChar(char[] x, char[] y) {
	int i;
	for (i = 0; i < x.length && i < y.length && x[i] == y[i]; i++);
	return i < x.length && i < y.length && x[i] < y[i];
    }

    // public static <T> void checkArrays(T[] x, T[] y) {
    // 	System.out.println("" + x + " " + y + " " + isLess(x,y));
    // }

    public static void checkArraysInt(int[] x, int[] y) {
	System.out.println("" + x + " " + y + " " + isLessInt(x,y));
    }

    public static void checkArraysChar(char[] x, char[] y) {
	System.out.println("" + x + " " + y + " " + isLessChar(x,y));
    }

    public static void main(String...args) {
	int a[] = { 2, 3, 5, 7, 9};
	int b[] = { 2, 3, 5, 7, 11};
	char c[] = { 'L', 'A', 'B', 'E', 'L' };
	char d[] = { 'L', 'I', 'B', 'E', 'L' };
	checkArraysInt(a,b);
	checkArraysChar(c,d);
    }
}
