/* Definición del servicio de notaria, sellador */
package elcastillo.notaria;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sellador extends Remote {

    String sellador() throws RemoteException;
}
