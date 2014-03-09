public class Super {
    String s = new String("s");
    Super() {
	printThree(); 
	printS();
    }
    void printThree() {
	System.out.println("three");
    }
    void printS() {
	System.out.println(s);
    }
}