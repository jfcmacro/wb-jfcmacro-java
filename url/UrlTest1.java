import java.net.*;
import java.io.*;
import java.util.*;

public class UrlTest1 {

    public static void main(String []args) {

	for (int i = 0; i < args.length; i++) {

        try {

            String serie = args[0];

            for (int index = 1; index < 21; index++) {

                URL u = new URL("http://www.ulib.org/webRoot/Books/Numerical_Recipes/bookcpdf/" +
				args[i]);
                InputStream in = u.openStream();
                in = new BufferedInputStream(in);

                Reader r = new InputStreamReader(in);
                OutputStream out =
                    new BufferedOutputStream(new FileOutputStream(new File(args[i])));

                int c;
                while ((c = r.read()) != -1) {
                    out.write((byte) c);
                }
                out.flush();
                out.close();
                System.out.println(" end: " +
                                   args[i]);
            }

        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
	}
    }
}

