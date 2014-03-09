class Entero {
    private int value;
    public Entero(int value) {
	this.value = value;
    }

    public void setValue(int value) {
	this.value = value;
    }

    public int getValue() {
	return value;
    }

    public String toString() {
	return ""+ value;
    }
}

public class SwapInteger {

    public static void swapEntero(Entero a, Entero b) {
	Entero tmp = new Entero(a.getValue());
	a.setValue(b.getValue());
	b.setValue(tmp.getValue());
    }

    public static void swapInteger(Integer a, Integer b) {
	Integer tmp = new Integer(a.intValue());
	a = new Integer(b.intValue());
	b = new Integer(tmp.intValue());
    }

    public static void doSwapping1() {
	Integer x, y;
	x = 100;
	y = 200;
	System.out.println("x: " + x + " y: " + y);
	swapInteger(x,y);
	System.out.println("x: " + x + " y: " + y);
    }

    public static void doSwapping2() {
	Entero x = new Entero(100);
	Entero y = new Entero(200);
	System.out.println("x: " + x + " y: " + y);
	swapEntero(x,y);
	System.out.println("x: " + x + " y: " + y);
    }

    public static void main(String []args) {
	doSwapping1();
	doSwapping2();
    }
}