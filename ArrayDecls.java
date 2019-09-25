public class ArrayDecls {

    public static void main(String[] args) {
	int[] a_uno, a_dos;
	int   b_uno[], b_dos;

	a_uno = new int[1];
	a_dos = new int[1];
	b_uno = new int[1];
	System.out.println("a_uno.class = " + a_uno.getClass());
	System.out.println("a_dos.class = " + a_dos.getClass());
	System.out.println("b_uno.class = " + b_uno.getClass());
	// System.out.println("b_dos.class = " + b_dos.getClass());
    }
}
