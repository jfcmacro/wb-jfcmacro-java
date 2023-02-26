package org.jfcmc.io;

import java.io.File;
import java.io.IOException;

/**
 * Compare a document
 * @author Juan Cardona
 * @since 1.0
 */
public class Compare {
    /**
     * @hidden
     * @param args A set of arguments it is empty
     * @exception java.io.IOException A kind of exception
     */
    public static void main(String []args)
    throws IOException {
        if (args.length != 2) {
            System.err.println("usage: java org.jfcmc.io.Compare filespec1 filespec2");
            System.exit(1);
        }
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        System.out.println(file1.compareTo(file2));
        System.out.println(file1.getCanonicalFile()
                           .compareTo(file2.getCanonicalFile()));
    }
}
