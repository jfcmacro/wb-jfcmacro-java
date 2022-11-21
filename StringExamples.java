
public class StringExamples {

    public static void example_longer_string_error() {
        // String str = "This is a longer string \ 
        //     this is new data";
        // System.out.println(str);
    }

    public static void example_longer_string_no_error() {
        String str = "This is a longer string " +
            " this is new data";
        System.out.println(str);
    }

    public static void example_using_unicode() {
        String str = "\u0054his is a longer string " +
            " this is new \u0064\u0061\u0074\u0061";
        System.out.println(str);
    }

    public static void main(String []args) {
        example_longer_string_error();
        example_longer_string_no_error();
        example_using_unicode();
    }

}
