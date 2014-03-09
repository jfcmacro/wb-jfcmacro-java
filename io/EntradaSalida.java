import java.io.*;

public class EntradaSalida {


    public static void main(String []args) {

	int c;

	try {
	    while ((c = System.in.read()) != -1) {
		byte aByte = (byte) c;
		char aChar = (char) aByte;
		System.out.print(aByte);
		System.out.println(aChar);
	    }
	} catch (IOException ioe) {

	    System.out.println("Exception: " + ioe);
	    System.exit(1);
	}
    }
} 
