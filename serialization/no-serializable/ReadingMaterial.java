import java.io.*;

// The superclass DOES NOT implement serializable
class ReadingMaterial  {

    /**
     * We do not make these private because we need the subclass Book to be
     * able to save the state of this superclass.
     * Alternatively, we could make these private and create set and get
     *  functions that would allow access to the Book subclass.
     * If we failed to do that with private fields, then fields would not
     * be saveable!
     */
    protected String author;
    protected String subject;
    protected int yearwritten;

    // other relevant data and methods
    // .
    // .
    // .

    /*
     * a mandatory public no-arg constructor... will be used to reconstruct
     * this non-serializable class.
     */
    public ReadingMaterial() {}

    ReadingMaterial(String auth, String sub, int year) {
        author = auth;
        subject = sub;
        yearwritten = year;
    }
}
