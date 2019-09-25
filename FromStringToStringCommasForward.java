import java.util.Scanner;

public class FromStringToStringCommasForward {

    public static void main(String []args) {

	Scanner scan = new Scanner(System.in);

	System.out.print("Write down a number: ");
	String input = scan.nextLine();
	StringBuffer output = new StringBuffer();
	final int SIZE = 3;
	int offset = input.length() % SIZE;

	if (offset != 0)
	    output.append(input.substring(0, offset));

	final int times = ((input.length() - offset) / SIZE) - (offset == 0 ? 1 : 0);

	for (int i = 0; i < times; i++, offset += SIZE)
	    output.append(',').append(input.substring(offset, offset + SIZE));

	if (offset < input.length())
	    output.append(input.substring(offset, offset + SIZE));

	System.out.println("Number with commas: " + output);
    }
}
