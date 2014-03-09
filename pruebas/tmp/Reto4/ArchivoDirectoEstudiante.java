import java.io.*;

/**
 * ArchivoDirectoEstudiante
 * Implementa las operaciones basicas sobre un
 * archivo directo en el cual la clave es la posicion
 * del registro en el rachivo.
 */
 
public class ArchivoDirectoEstudiante { 
	
	private RandomAccessFile raf_ = null;
	private int longitudRegistro_ = 0;
	
	// Se abre el archivo "nombre" para lectura y escritura.
	// Si no existe, se crea uno nuevo.
	
	public void inicio()
	{
		try{
		raf_.seek(0);
		}
		
		catch(IOException e)
		{
			e.printStackTrace();		
		}	
	}
	
	public ArchivoDirectoEstudiante(String nombre, int longitudRegistro) {
		longitudRegistro_ = longitudRegistro;
		try {
			raf_ = new RandomAccessFile(nombre, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		}
	}
	
	// Se cierra el archivo
	public void cerrar() 
		throws IOException {
			raf_.close();	
	}
	
	// Se escribe un registro, la posicion es la clave
	public void escribirUnRegistro(Registro re) 
		throws IOException {
		saltarAlRegistro(re.valorEnteroClave());
		raf_.writeBytes(re.armarRegistro());	
	}
	
	
	// Se lee un registro, la clave es la misma posicion
	public RegistroEstudiante leerUnRegistro(int clave) 
		throws IOException {
		// ir a donde el archivo debe estar
		saltarAlRegistro(clave);
		// leer lo que hay alli
		byte [] buffer = new byte[longitudRegistro_];
		raf_.read(buffer);
		// ver si corresponde con la clave buscada
		RegistroEstudiante re = new RegistroEstudiante(buffer);
		if (clave == re.valorEnteroClave()) {
			return re;	
		} else {
			return null;
		}
	}
	
	
	// Se mueve el apuntador al comienzo del registro n
	public void saltarAlRegistro(long n) 
		throws IOException {
		raf_.seek(n * longitudRegistro_);
	}
	
	// Programa principal
	public static void main(String [] args) {
		ArchivoDirectoEstudiante ade = 
			new ArchivoDirectoEstudiante("datos.txt", 
			RegistroEstudiante.longitudRegistro);
		RegistroEstudiante re = null;
		try {
			// Escribir algunos registros
			re = new RegistroEstudiante("0001", "cien");
			ade.escribirUnRegistro(re);
			re = new RegistroEstudiante("0002", "doscientos");
			ade.escribirUnRegistro(re);
			re = new RegistroEstudiante("0003", "trescientos");
			ade.escribirUnRegistro(re);
			// notar que el "0004" nunca se escribe
			re = new RegistroEstudiante("0005", "quinientos");
			ade.escribirUnRegistro(re);
			// Leer utilizando la clave como posicion
			System.out.println(ade.leerUnRegistro(1));	
			System.out.println(ade.leerUnRegistro(2));	
			System.out.println(ade.leerUnRegistro(3));	
			System.out.println(ade.leerUnRegistro(4));	
			System.out.println(ade.leerUnRegistro(5));	

			ade.cerrar();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}	
	
}