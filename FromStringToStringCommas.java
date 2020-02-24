import java.util.Scanner;

public class FromStringToStringCommas {

    public static void main(String []args) {

	Scanner scan = new Scanner(System.in);
	final int SIZE = 3;

	System.out.print("Write down a number: ");
	String input = scan.nextLine();
	StringBuffer output = new StringBuffer();
	int i = input.length();

	for (; i > SIZE; i-=SIZE)
	    output.insert(0,input.substring((i-SIZE), i)).insert(0,(((i - SIZE) == 0) ? "" : ',' ));

	// if (i > 0)
	//     output.insert(0, input.substring(0, i));

	System.out.println("Number with commas: " + output);
    }
}
