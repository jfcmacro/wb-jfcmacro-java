import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadLine {
    public static void main(String []args) {
	try {
	    BufferedReader br =
		new BufferedReader(new InputStreamReader(System.in));

	    for (String s = br.readLine();
		 s != null;
		 s = br.readLine()) {
		System.out.println(s);
	    }
	}
	catch (IOException ioe) {
	    System.err.println("Exception: " + ioe);
	}
    }					 
}
