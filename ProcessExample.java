import java.lang.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ProcessExample {

    public static void main(String []args) {

	if (args.length != 1) {
	    System.err.println("Uso: java ProcessExample command");
	    System.exit(1);
	}

	try {
	    
	    Runtime r = Runtime.getRuntime();
	    Process process = r.exec(args[0]);
	    BufferedReader br = 
		new BufferedReader(new 
				   InputStreamReader(process.getInputStream()));
	    String s = br.readLine();
	    while (s != null) {
		System.out.println(s);
		s = br.readLine();
	    }
	    
	} catch (IOException ioe) {
	    System.err.println("Exception: " + ioe);
	}
    }
}