import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main4 {

    public static void main(String...args)
    // throws FileNotFoundException
    {
        boolean correctedFile = false;

        do {
            try {
                File file = new File(args[0]);
                
                Scanner scan = new Scanner(file);
                // class Scanner { public Scanner(File file) throws FileNotFoundException{ ... }
                correctedFile = true;
                while (scan.hasNext()) {

                    String str = scan.nextLine();
                }
            } catch(FileNotFoundException fnfe) {
                System.err.println("File not found: " + args[0]);
                Scanner scan2 = new Scanner(System.in);
                String fileName = scan2.nextLine();
                args[0] = fileName;
                // throw fnfe;
            }
            
        } while (!correctedFile);
    }
}
