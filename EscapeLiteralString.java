public class EscapeLiteralString {

    public static void main(String[] args) {

        String str = "C:\\Users\\";
        String unix = "~/prueba/otro/directorio/document.txt";
        String windows = unix.replace("~/", str).replaceAll("/", "\\\\");

        System.out.printf("unix: %s windows: %s%n", unix, windows);
    }
}
