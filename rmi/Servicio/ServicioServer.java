import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.Naming;

public class ServicioServer {

	public static void main(String[] args) {
		try {
			ServicioImpl si = new ServicioImpl();
			Naming.rebind("Servicio", si);
			System.out.println("Servicio listo");
		}
		catch (RemoteException re) {
			System.err.println("Exception en Servicio: " +re);
		}
		catch (MalformedURLException e) {
			System.err.println("MalformedURLException " + e);
		}
	}
}
