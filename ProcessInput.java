import java.util.*;

public class ProcessInput {

    public static void main(String args[]) {
	Scanner key = new Scanner(System.in);
	int val;

	while (key.hasNext()) {
	    val = key.nextInt();
	    System.out.println(val);
	}
    }
}
