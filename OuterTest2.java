public class OuterTest2 {
    public static void main(String []args) {
        Outer2 out = new Outer2();
        Outer2.Inner2 in = out.new Inner2();

        out.printValue();
        in.printValue();

        out.setValue(828);

        out.printValue();
        in.printValue();
    }
}
