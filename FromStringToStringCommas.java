import java.util.Scanner;

public class FromStringToStringCommas {

    public static void main(String []args) {

	Scanner scan = new Scanner(System.in);

	System.out.print("Write down a number: ");
	String input = scan.nextLine();
	StringBuffer output = new StringBuffer();
	int i = input.length();

	for (; i > 3; i-=3)
	    output.insert(0,input.substring((i-3), i)).insert(0,(((i - 3) == 0) ? "" : ',' ));

	if (i > 0)
	    output.insert(0, input.substring(0, i));

	System.out.println("Number with commas: " + output);
    }
}
