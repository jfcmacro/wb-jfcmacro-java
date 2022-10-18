import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class ISO216DocumentTestCaseRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ISO216DocumentTestCase.class);
        System.out.println("Total test: " + result.getRunCount() +
                           " test passed: " + (result.getRunCount() - result.getFailureCount()) +
                           " test failured: " + result.getFailureCount());
        System.out.println(result.getFailures());
    }
}
