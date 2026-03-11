
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExer01 {

    public static void main(String[] args) {
	try (DataOutputStream out =
	     new DataOutputStream(
				  new BufferedOutputStream(
							   new FileOutputStream("data/example.dat")))) {
	    out.writeInt(123);
	    out.writeDouble(-0.55);
	    out.flush();
	} catch (IOException e) {
	    System.err.println(e.getMessage());
	}

	try (DataInputStream in =
	     new DataInputStream(
				 new BufferedInputStream(
							 new FileInputStream("data/example.dat")))) {
	    double d = in.readDouble();
	    int i = in.readInt();
	    System.out.println(i + " " + d);
	} catch (IOException e) {
	    System.err.println(e.getMessage());
	}
    }
}
