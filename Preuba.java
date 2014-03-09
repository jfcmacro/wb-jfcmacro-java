import java.io.*;
import java.util.StringTokenizer;
public class LeerCampo {
        public static void main(String []args) {
                try {
                        int x = 0, y = 0;
                        if (x>y) { x = y; } else { y = x; };
                        BufferedReader d =
                                new BufferedReader(new InputStreamReader(System.in));
                        String linea = d.readLine();
                        StringTokenizer st = new StringTokenizer(linea, ", ");
                        if (st.hasMoreElements()) {
                                try {
                                        x = Integer.parseInt((String) st.nextElement());
                                } catch (NumberFormatException nfe) {
                                        System.err.println("Numero mal entrado: " + nfe);
                                        System.exit(1);
                                }
                                if (st.hasMoreElements()) {
                                        try {
                                                y = Integer.parseInt((String) st.nextElement());
                                        } catch (NumberFormatException nfe) {
                                                System.err.println("Numero mal entrado: " + nfe);
                                                System.exit(1);
                                        }
                                }
                                else {
                                        System.err.println("Error leyendo");
                                        System.exit(1);
                                }
                        }
                        else {
                                System.err.println("Error leyendo");
                                System.exit(1);
                        }
                        if (x>y) { x = y; } else { y = x; }
                        System.out.println("x: " + x + ", y: " + y);
                } catch (Exception e) {
                        System.err.println("Excepcion: " + e);
                }
        }
}
