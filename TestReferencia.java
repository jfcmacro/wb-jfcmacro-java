class InnerClass {
    public int x;
    public int y;
    public InnerClass(int x, int y) {
	this.x = x;
	this.y = y;
    }
}

public class TestReferencia {


    public TestReferencia() {
    }

    public void test(int x, InnerClass ic) {
	x = x + 20;
	ic.x = ic.x + 10;
	ic.y = ic.y + 20;
	return;
    }

    public static void main(String args[]) {
	TestReferencia tr = new TestReferencia();
	int x = 6;
	InnerClass ic = new InnerClass(5,6);
	System.out.println("x: " + x + " ic.x = " + ic.x
			   + " ic.y = " + ic.y);
	tr.test(x,ic);
	System.out.println("x: " + x + " ic.x = " + ic.x
			   + " ic.y = " + ic.y);
	System.exit(0);
    }
}