public class ModifiedOuter2 {
    private int value = 1116;

    public class Inner {
        private int value = 1720;

        public void printValue() {
            System.out.println("\nInner - printValue()...");
            System.out.println("Inner: Value = " + value);
            System.out.println("Outer: Value = " + ModifiedOuter2.this.value);
        }
    }

    public void printValue() {
        System.out.println("\nOuter - printValue()...");
        System.out.println("Outer: Value = " + value);
    }

    public void setValue(int newValue) {
        System.out.println("\nSetting Outer's value to " + newValue);
        value = newValue;
    }
}
