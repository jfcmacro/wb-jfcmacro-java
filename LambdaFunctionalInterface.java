@FunctionalInterface
interface MyFunctionalInterface {
    String sayHello();
}

public class LambdaFunctionalInterface {
    public static void main(String []args) {
        MyFunctionalInterface msg = () -> "Hello";
        System.out.println(msg.sayHello());
    }
}
