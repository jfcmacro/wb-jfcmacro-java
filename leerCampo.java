#define CERO 0
#define MAX(z,w) if (z>w) { w = z; } else { z = w; }
import java.io.*;
import java.util.StringTokenizer;

public class LeerCampo {

	public static void main(String []args) {

		try {
			int x = CERO, y = CERO;

                        // if (x > y) { x = y; } else { y = x; }
		        MAX(x,y);
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


                        MAX(x,y)
			System.out.println("x: " + x + ", y: " + y);
		} catch (Exception e) {
			System.err.println("Excepcion: " + e);
		}
	}

}
