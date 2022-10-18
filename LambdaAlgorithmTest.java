interface Hello {
    String sayHello(String greet);
}

public class LambdaAlgorithmTest {
    public static void main(String[] args) {
        Hello hello = (message) -> {
            String str1 = "Welcome ";
            String str2 = str1 + message;
            return str2;
        };
        System.out.println(hello.sayHello("Lambda tutorial"));
    }
}
