public class Swap2 {

    public static void swap(int x, int y) {
        int tmp = x;
        x = y;
        y = tmp;
    }

    static class RefInt {
        int value;

        RefInt(int value) {
            this.value = value;
        }

        void setValue(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }

    public static void swap(RefInt x, RefInt y) {
        int tmp = x.getValue();
        x.setValue(y.getValue());
        y.setValue(tmp);
    }

    public static void swap(String x, String y) {
        String tmp = x;
        x = y;
        y = tmp;
    }

    public static void main(String...args) {

        int a = 10;
        int b = 20;

        System.out.printf("a: %d b: %d%n", a, b);

        swap(a,b);

        System.out.printf("a: %d b: %d%n", a, b);

        RefInt rA = new RefInt(a);
        RefInt rB = new RefInt(b);

        System.out.printf("a: %d b: %d%n", rA.getValue(), rB.getValue());

        swap(rA, rB);

        System.out.printf("a: %d b: %d%n", rA.getValue(), rB.getValue());

        String sA = "Hola";
        String sB = "Adios";

        System.out.printf("sa: %s sb: %s%n", sA, sB);
        swap(sA, sB);
        System.out.printf("sa: %s sb: %s%n", sA, sB);
    }
}
