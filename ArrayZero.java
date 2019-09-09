public class ArrayZero {

    private static int nElem;
    private int value;

    public ArrayZero() {
	value = ++nElem;
    }

    public int getValue() {
	return value;
    }

    public static void main(String[] args) {
	ArrayZero[] tmp = new ArrayZero[0];
    }
}
