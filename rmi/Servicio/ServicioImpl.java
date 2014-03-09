import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.HashMap;

public class ServicioImpl implements Servicio {
	
	private Map<String,Cliente> clientes = new HashMap<String,Cliente>();
	
	public ServicioImpl() throws RemoteException {
		UnicastRemoteObject.exportObject(this);
	}

	private Cliente obtenerCliente(String clave) {
		Cliente c = (Cliente) clientes.get(clave);
		return c;
	}
	
	private void adicionarCliente(String clave) {
		clientes.put(clave, new Cliente(clave));
	}
	
	public String conectar(int id) throws RemoteException {
	
		String clave = "Clave " + Integer.toString(id);
		
		if (obtenerCliente(clave) == null) 
			adicionarCliente(clave);
		return null;
	}

	public int solicitarPeticion(String clave, int valor) throws RemoteException {
		Cliente c = obtenerCliente(clave);
		c.incrementarPeticion();
		return c.obtenerPeticiones() + valor;
	}

	public void terminar(String clave) throws RemoteException {
		clientes.remove(clave);
	}

}
 