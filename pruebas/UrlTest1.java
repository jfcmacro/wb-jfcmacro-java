import java.net.*;
import java.io.*;
import java.util.*;

public class UrlTest1 {

    public static void main(String []args) {

        try {

            String serie = args[0];

            for (int index = 1; index < 21; index++) {
                // URL u = new URL("http://www.mujeresmamando.com/spics/sinnombre" + index + ".jpg");
                // URL u = new URL("http://www.icdc.com/~paulwolf/gaitan/archives/hillenkoetter15april1948" + i + ".jpg");

                System.out.print("Start: serie-" +
                                 serie +
                                 "/0" +
                                 (index > 9 ? "" + index : "0" + index));

                URL u = new URL("http://www.sleazydream.com/" +
                                serie +
                                "/0" +
                                (index > 9 ? "" + index : "0" + index) +
                                ".jpg");
                InputStream in = u.openStream();
                in = new BufferedInputStream(in);

                Reader r = new InputStreamReader(in);
                OutputStream out =
                    new BufferedOutputStream(new FileOutputStream(new File("serie-"+
                                                                           serie +
                                                                           (index > 9 ? "" + index : "0" + index) +".jpg")));

                int c;
                while ((c = r.read()) != -1) {
                    out.write((byte) c);
                }
                out.flush();
                out.close();
                System.out.println(" end: serie-" +
                                   serie +
                                   "/0" +
                                       (index > 9 ? "" + index : "0" + index));
            }

        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}
