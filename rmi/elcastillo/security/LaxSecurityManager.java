package elcastillo.security;

import java.rmi.RMISecurityManager;
import java.security.Permission;

public class LaxSecurityManager 
    extends RMISecurityManager {

    public void checkPermission(Permission p) {
	// hace nada
    }
}
