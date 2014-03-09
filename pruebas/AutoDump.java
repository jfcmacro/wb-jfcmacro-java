public class AutoDump {
    public static void m1() {
	m2();
    }

    public static void m2() {
	m3();
    }

    public static void m3() {
	        Throwable t = new Throwable();
        StackTraceElement elements[] = t.getStackTrace();
	for (int i = 0; i < elements.length; i++)
	    System.out.println(elements[i]);
        String method = elements[0].getMethodName();

        System.out.println("Method: " + method);
    }
    public static void main(String args[]) {
	m1();
    }
}
