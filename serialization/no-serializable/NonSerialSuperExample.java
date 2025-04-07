import java.io.*;

public class NonSerialSuperExample {

    /**
     * Creates a book object, serializes it, deserializes it and then prints
     * out to test that the serialization did work.
     */
    public static void main(String args[]) {

        // create a Book object
        Book bookorg = new Book(100, "How to Serialize", true, "R.R", "Serialization", 1997);
        Book booknew = null;

        // serialize the Book
        try {
            FileOutputStream fo = new FileOutputStream("tmp");
            ObjectOutputStream so = new ObjectOutputStream(fo);
            so.writeObject(bookorg);
            so.flush();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        // deserialize the Book
        try {
            FileInputStream fi = new FileInputStream("tmp");
            ObjectInputStream si = new ObjectInputStream(fi);
            booknew = (Book) si.readObject();
        }catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }

	// The books should be the same if we did everything correctly!
        System.out.println();
        System.out.println("Printing original book...");
        System.out.println(bookorg);
        System.out.println("Printing new book... ");
        System.out.println(booknew);
        System.out.println("The original and new should be the same!");
        System.out.println();
    }
}
