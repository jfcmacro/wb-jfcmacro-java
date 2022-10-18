import java.util.ArrayList;

public class SuppressWarningTest {
    @SuppressWarnings({"unchecked", "deprecated"})
    public void test() {
        ArrayList list = new ArrayList();
        list.add("Hello");
    }
}
