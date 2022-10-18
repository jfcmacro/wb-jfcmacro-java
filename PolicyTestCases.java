import java.io.IOException;

public class PolicyTestCases {
    @TestCase(willThrow = IOException.class)
    public static void testCase1() {
    }
    @TestCase()
    public static void testCase2() {
    }
}
