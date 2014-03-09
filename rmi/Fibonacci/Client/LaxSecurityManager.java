import java.rmi.*;
import java.security.*;

public class LaxSecurityManager extends RMISecurityManager 
{
	public void checkPermission(Permission p) {
		// hace nada
	}
}
