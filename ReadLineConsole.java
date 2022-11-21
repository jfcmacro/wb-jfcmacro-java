import java.io.Console;

public class ReadLineConsole {
    public static void main(String[] args) {
        Console cons = System.console();
        if (cons != null) {
            int number = Integer.parseInt(System.console().readLine());
            System.out.println("Read Number: " + number);
        }
    }
}
