public class SwapInt {

    static class IntValue {
	public int intValue;
	IntValue(int a) {
	    intValue = a;
	}

	public String toString() {
	    return "" + intValue;
	}
    }

    public static void swap(int a, int b) {
	int tmp;
	tmp = a;
	a = b;
	b = tmp;
    }

    public static void swap(Integer a, Integer b) {
	Integer tmp = a;
	a = b;
	b = tmp;
    }

    public static void swap(IntValue a, IntValue b) {
	int tmp = a.intValue;
	a.intValue = b.intValue;
	b.intValue = tmp;
    }

    public static void main(String []args) {
	int a = 10;
	int b = 20;

	swap(a,b);
	System.out.println("a: " + a +
			   " b: " + b);
	Integer intA = 10;
        Integer intB = 20;

	swap(intA, intB);

	System.out.println("intA: " + intA +
			   " intB: " + intB);

	IntValue intV_A = new IntValue(10);
	IntValue intV_B = new IntValue(20);

	swap(intV_A, intV_B);
	System.out.println("intA: " + intV_A +
			   " intB: " + intV_B);
    }
}
