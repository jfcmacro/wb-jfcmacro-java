public class Ref {

    private static int value;
    
    public static void printRef(Object o) {
	System.out.println(o);
    }

    public static void printInt(int i) {
	System.out.println(i);
    }

    public static void main(String []args) {

	Object o = null;

	printRef(o);

	String str;
	str = null;

	printRef(str);

	int i;

	printInt(value);
    }
}
