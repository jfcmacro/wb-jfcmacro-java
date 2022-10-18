import java.util.ArrayList;

public class CallbackTest {
    private ArrayList<Callable> callableList = new ArrayList<>();

    public static void main(String[] args) {
        CallbackTest cbt = new CallbackTest();

        Callable c1 = cbt.generateCallable(1);
        cbt.register(c1);

        Callable c2 = cbt.generateCallable(2);
        cbt.register(c2);

        Callable c3 = cbt.generateCallable(3);
        cbt.register(c3);

        cbt.callback();
    }

    private void callback() {
        for (Callable c: callableList) {
            c.call();
        }
    }

    public void register(Callable c) {
        this.callableList.add(c);
    }

    public Callable generateCallable(int no) {
        return new Callable() {
            public void call() {
                System.out.println("Called #" + no);
            }
        };
    }
}
