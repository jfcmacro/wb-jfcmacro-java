public class OuterTest {
    public static void main(String []args) {
        Outer out = new Outer();
        Outer.Inner in = out.new Inner();

        out.printValue();
        in.printValue();

        out.setValue(828);

        out.printValue();
        in.printValue();
    }
}
