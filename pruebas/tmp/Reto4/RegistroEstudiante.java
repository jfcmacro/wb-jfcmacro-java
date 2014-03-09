/**
 * Registro.class
 * Un registro muy sencillo que consta de:
 * cédula 
 * nombre
 * Los campos están separados por una coma.
 */
 
public class RegistroEstudiante 
	implements Registro {
	protected String cedula_ = null;
	protected String nombre_ = null;
	public static final int longCedula = 4;
	public static final int longNombre = 36;
	public static final int longitudRegistro = 40;
	private boolean DEBUG = false;
	
	// Constructor.  Recibe los campos como string
	public RegistroEstudiante(String cedula, String nombre) {
		cedula_ = cedula;
		nombre_ = nombre;	
	}
	
	// Constructor.  Recibe el arreglo de bytes que se lee del archivo
	public RegistroEstudiante(byte [] buffer) {
		String registro = new String(buffer);
		cedula_ = registro.substring(0,longCedula);
		nombre_ = registro.substring(longCedula, longCedula + longNombre - 1);
		if (DEBUG) {
			System.out.println("En Registro Estudiante, constructor, registro = " + registro);	
			System.out.println("En Registro Estudiante, constructor, cedula_ = " + cedula_);	
			System.out.println("En Registro Estudiante, constructor, nombre_ = " + nombre_);	
		}
	}
	
	// Convierte el registro a string, para poderlo mostrar por consola
	public String toString() {
		return cedula_ + nombre_;
	}
	
	// Arma un string donde cada campo tiene la longitud adecuada.
	// Los espacios que sobran se rellenan con blancos
	public String armarRegistro() {
		char [] buffer = new char[longCedula + longNombre];
		
		int longitud = java.lang.Math.min(longCedula, cedula_.length());
		for (int i = 0; i < longitud; i++) {
			buffer[i] = cedula_.charAt(i);	
		}	
		for (int i = longitud; i < longCedula; i++) {
			buffer[i] = ' ';	
		}
		
		longitud = java.lang.Math.min(longNombre, nombre_.length());
		for (int i = 0, j = longCedula; j < longCedula + longitud; i++, j++) {
			buffer[j] = nombre_.charAt(i);	
		}
		for (int i = longCedula + longitud; i < longCedula + longNombre; i++) {
			buffer[i] = ' ';	
		}
		
		return new String(buffer);
	}
	
	// Devuelve la longitud de todo el registro
	public static int getLongitudRegistro() {
		return longitudRegistro;	
	}

	// Devuelve true si la clave del registro es igual a la del buffer
	public boolean compararClave(byte [] buffer) {
		String registro = new String(buffer);
		String cedula = registro.substring(0,longCedula - 1);
		return (cedula_.trim().compareTo(cedula.trim()) == 0);
	}
	
	// Retorna el valor entero de la clave, para usarlo como posicion
	public int valorEnteroClave() {
		int valor = -1;
		if (DEBUG) {
			System.out.println("En RegistroEstudiante, cedula = " + cedula_);	
		}
		try {
			valor = (new Integer(cedula_)).intValue();
		} catch(NumberFormatException e) {
		}
		return valor;	
	}
	
	public String cedula_(){
		return cedula_;
	}
	
	// Programa principal para pruebas de esta clase
	public static void main(String [] args) {
		RegistroEstudiante re = new RegistroEstudiante("100", "cien");
		System.out.println(re.armarRegistro() + "fin");	
	}
}