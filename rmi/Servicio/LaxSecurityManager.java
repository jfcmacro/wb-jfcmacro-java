import java.rmi.RMISecurityManager;
import java.security.Permission;

public class LaxSecurityManager extends RMISecurityManager {
	
	
	public void checkConnect(String host, int port) {
		System.out.println("Se puede conectar en " + host + ":" + port);
	}
	
	public void checkPermissio(Permission p) {
		// do nothing
	}

}
