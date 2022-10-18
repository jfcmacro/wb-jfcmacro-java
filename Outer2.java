public class Outer2 {
    private int value = 1116;

    public class Inner2 {
        private int value = 1720;
        public void printValue() {
            System.out.println("Inner2-Value: " + value);
        }
    }

    public void printValue() {
        System.out.println("Outer2-Value: " + value);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
