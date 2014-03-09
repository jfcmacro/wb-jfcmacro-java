/* Definición del servicio de registro */
package elcastillo.registro;

import java.rmi.*;

public interface Registro extends Remote {

    public int registrar() throws RemoteException;
}
