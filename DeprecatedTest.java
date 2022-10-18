
@Deprecated(forRemoval = true, since = "Right now")
public class DeprecatedTest {
    private DeprecatedTest() {
    }

    public static DeprecatedTest getInstance() {
        DeprecatedTest dt = new DeprecatedTest();
        return dt;
    }
}
