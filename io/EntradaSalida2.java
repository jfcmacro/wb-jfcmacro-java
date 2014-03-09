import java.io.*;

public class EntradaSalida2 {


    public static void main(String []args) {

	DataInputStream dis = new DataInputStream(System.in);

	try {
	    char c;
	    int valor;
	    float valorf;
	    
	    while (true) {
		c = dis.readChar();
		valor = dis.readInt();
		valorf = dis.readFloat();
		System.out.println("" + c + " " + valor + " " + valorf);

	    }
	} catch (EOFException eof) {
	    System.err.println("EOFException: " + eof);
	}
	catch (IOException ioe) {
	    System.out.println("Exception: " + ioe);
	    System.exit(1);
	}
    }
} 
