import java.io.*;

class Book extends ReadingMaterial implements Serializable {

    int numpages;
    String name;
    boolean ishardcover;

    // other relevant information and methods
    // .
    // .
    // .

    Book(int pages, String n, boolean hardcover, String author,
         String subject, int yearwritten)
    {
        super(author, subject, yearwritten);
        numpages = pages;
        name = n;
        ishardcover = hardcover;
    }

    /**
     * Saves its own fields by calling defaultWriteObject and then explicitly
     * saves the fields of its supertype
     *
     * @serialData Store own serializable fields by calling defaultWriteObject
     *             and save supertype fields as optional data. Optional
     *             data is written in following sequence; author field
     *             is written as object, subject is an object and the
     *             yearwritten field is written as an integer.
     */
    private void writeObject(ObjectOutputStream out)  throws IOException {

        // Take care of this class's field first by calling defaultWriteObject
        out.defaultWriteObject();

        /*
         * Since the superclass does not implement the Serializable interface
         * we explicitly do the saving... Since these fields are not private
         * we can access them directly. If they were private, the superclass
         * would have to implement get and set methods that would allow the
         * subclass this necessary access for proper saving.
         */
        out.writeObject(author);
        out.writeObject(subject);
        out.writeInt(yearwritten);
    }

    /**
     * Restores its own fields by calling defaultReadObject and then explicitly
     * restores the fields of its supertype.
     */
    private void readObject(ObjectInputStream in)
        throws IOException, ClassNotFoundException {

            /*
             * Take care of this class's fields first by calling
             * defaultReadObject
             */
            in.defaultReadObject();

            /*
             * Since the superclass does not implement the Serializable
             * interface we explicitly do the restoring... Since these fields
             * are not private we can access them directly. If they were
             * private, the superclass would have to implement get and set
             * methods that would allow the subclass this necessary access
             * for proper saving or restoring.
             */
            author = (String) in.readObject();
            subject = (String) in.readObject();
            yearwritten = in.readInt();
    }

    /** Print out the field values. Useful for testing.
     */
   public String toString() {
        return("Name: " + name + "\n" + "Author: " + author + "\n" + "Pages: "
               + numpages + "\n" + "Subject: " + subject + "\n" + "Year: " + yearwritten
               + "\n");
    }
}
