public class Test extends Super {
    int three = (int)Math.PI;
    public static void main(String[] args) {
	Test t = new Test();
	t.printThree();
	t.printS();
    }
    void printThree() {
	System.out.println(three);
    }
    void printS() {
	System.out.println("SS");
    }
}