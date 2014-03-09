/*
 * Esta clase contiene la definicion del objeto Estudiante,
 * con sus atributos y metodos correspondientes
 */

public class Estudiante{
	private String codigo;
	private String nombre;
	
	public Estudiante(String codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	// Retorna el valor del codigo del estudiante
	public String codigo(){
		return codigo;
	}
	
	// Retorna el valor del nombre del estudiante
	public String nombre(){
		return nombre;
	}
	
	// Cambia el nombre del estudiante por "nuevo"
	public void cambiarN(String nuevo){
		nombre = nuevo;
	}
}