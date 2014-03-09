import java.lang.SecurityManager;
import java.lang.SecurityException;
import java.net.InetAddress;

public class OSSecurityManager extends SecurityManager {

    public OSSecurityManager() {
	super();
    }

    public void checkAccept(String host,
			    int port)
	throws SecurityException  {
	throw new SecurityException();
    }
    
    public void checkMulticast(InetAddress maddr)
	throws SecurityException  {
	throw new SecurityException();
    }

    public void checkMulticast(InetAddress maddr,
			       byte ttl)
	throws SecurityException  {
	throw new SecurityException();
    }
    
}
