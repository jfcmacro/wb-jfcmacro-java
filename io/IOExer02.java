
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExer02 {

    public static void main(String[] args) {
	try (ObjectOutputStream output =
	     new ObjectOutputStream(
				    new FileOutputStream("data/example.ser"))) {
	    output.writeObject(Integer.valueOf(123));
	    output.writeObject(Float.valueOf(-0.55f));
	} catch (FileNotFoundException e) {
	    System.err.println("File not found!");
	} catch (IOException e) {
	    System.err.println(e.getMessage());
	}

	try (ObjectInputStream input =
	     new ObjectInputStream(
				   new FileInputStream("data/example.ser"))) {
	    Float f = (Float) input.readObject();
	    Integer i = (Integer) input.readObject();
	    System.out.println(i + " " + f);
	} catch (IOException e) {
	    System.err.println(e.getMessage());
	} catch (ClassNotFoundException e) {
	    System.err.println(e.getMessage());
	}
    }
}
