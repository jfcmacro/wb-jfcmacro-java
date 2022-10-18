public class Outer {
    private int value = 1116;

    public class Inner {
        public void printValue() {
            System.out.println("Inner-Value: " + value);
        }
    }

    public void printValue() {
        System.out.println("Outer-Value: " + value);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
