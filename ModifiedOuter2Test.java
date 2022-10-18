public class ModifiedOuter2Test {
    public static void main(String[] args) {
        ModifiedOuter2 out = new ModifiedOuter2();
        ModifiedOuter2.Inner in = out.new Inner();

        out.printValue();
        in.printValue();

        out.setValue(828);

        out.printValue();
        in.printValue();
    }
}
