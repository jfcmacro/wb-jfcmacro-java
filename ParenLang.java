import java.io.StringReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class ParenLang {

    // This must be a LL(1) analizer, but I'm not using anticipate lecture.
    // Review
    private static boolean s(StringReader sr)
        throws IOException {
        int iChar = sr.read();
        if (iChar == -1) { // Epsilon
            return true;
        }
        if (iChar == '(') {
            if (s(sr)) {
                iChar = sr.read();
                if (iChar == ')') {
                    return s(sr);
                }
            }
            return false;
        }
        return false;
    }

    private static boolean p(String str) {
        Stack<Integer> stack = new Stack<>();
        str.chars().forEach(c -> {
                if (c == '(') stack.push(c);
                if (c == ')') {
                    if (!stack.empty() && stack.peek() == '(') stack.pop();
                }
            });

        return stack.empty();
    }

    private static boolean parser(String str) {
        boolean bRet = false;
        try {
            bRet = s(new StringReader(str));
        }
        catch (IOException io) {
        }
        return bRet;
    }

    public static void main(String...args) {
        Arrays.stream(args).forEach(str -> System.out.printf("%s: %b%n", str, p(str)));
    }
}
