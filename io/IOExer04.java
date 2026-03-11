import java.io.IOException;
import java.util.Scanner;

public class IOExer04 {
    public static void main(String[] args) throws IOException {
	try(Scanner scanner = new Scanner(System.in)) {
	    int x1 = 0;
	    x1 = scanner.nextInt();
	    System.out.println(x1);
	}
    }
}
