import java.util.Date;

public class Cliente {
	
	private Date horaConexion;
	private int nTotalPeticiones = 0;
	private String clave;
	static private int nextId = -1;
	
	public Cliente(String clave) {
		this.clave = clave;
		this.horaConexion = new Date();
	}
	
	public Date obtenerHoraConexion() {
		return horaConexion;
	}
	
	public String obtenerClave() {
		return clave;
	}
	
	public void incrementarPeticion() {
		nTotalPeticiones++;
	}
	
	public int obtenerPeticiones() {
		return nTotalPeticiones;
	}
	
	public static int obtenerSiguienteID() {
		return ++Cliente.nextId;
	}

}
