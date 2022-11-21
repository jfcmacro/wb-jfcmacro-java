public class MainValue {

    public static void method(Value value) {
        int val = value.getValue();
        val += 5;
        value.setValue(val);
    }

    public static void method2(final Value value) {
        int val = value.getValue();
        val += 6;
        value.setValue(val);
        // value = new Value(val); // This is an error.
    }

    public static void main(String[] args) {

        Value t1 = new Value(1);
        method(t1);
        t1.getValue();
        method2(t1);
        t1.getValue();

    }

}
