import java.rmi.RemoteException;
import java.rmi.Naming;
import java.util.Random;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class UsuarioServicio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length == 0 || !args[0].startsWith("rmi:")) {
			System.err.println("Usage: java UsuarioCliente rmi://localhost/Servicio");
			return;
		}
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new LaxSecurityManager());
		}
		
		try {
			Object o = Naming.lookup(args[0]);
			Servicio servicio = (Servicio) o;
			Random r = new Random(System.currentTimeMillis()); 
			int i = r.nextInt();
			String clave = servicio.conectar(i);
			int veces = r.nextInt(10000);
			
			for (int j = 0; j < veces; j++) {
				servicio.solicitarPeticion(clave, r.nextInt());
				try {
					Thread.sleep(r.nextInt(2000));
				} catch (InterruptedException e) { }
			}
			
		} catch (MalformedURLException e) {
			System.err.println(args[0] + " no es RMI URL valido");
		} catch (RemoteException e) {
			System.err.println("Objeto remoto lanzo excepción: " +e);
		} catch (NotBoundException e) {
			System.err.println("No se pudo encontrar el objeto remotoen el servidor");
		}
	}

}
