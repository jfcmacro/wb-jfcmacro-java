/*
 * Esta clase contiene metodos de busqueda, edicion, borrado y agregado
 * de objetos de la clase Estudiante en un Vector
 */

import java.util.Vector;

public class Aplicacion{
	
	// Guarda el listado de estudiantes
	private Vector estudiantes;
	
	public Aplicacion(){
		// Crea el Vector
		estudiantes = new Vector();
	}
	
	// Realiza una busqueda secuencial sobre el Vector de alumnos;
	// cuando lo encuentra lo retorna, si no lo encuentra, retorna un
	// valor nulo
	public Estudiante buscar(String clave){
		Estudiante e;
		for(int i = 0; i < estudiantes.size(); i++){
			e = (Estudiante)estudiantes.elementAt(i);
			if(e.codigo().equals(clave)){
				return e;
			}
		}
		return null;
	}
	
	// Agrega los estudiantes en el Vector de forma ascendente con respecto a 
	// su codigo, teniendo en cuenta que el codigo no puede estar previamente
	// registrado
	public int agregarOrd(String codigo, String nombre){
		Estudiante e = buscar(codigo);
		if(e != null){
			return -1;
		}
		
		// Si es el primer estudiante por agregar, simplemente lo agrega
		if(estudiantes.size() == 0){
			estudiantes.add(new Estudiante(codigo,nombre));
			return 0;
		}
		
		int i;
		
		for (i = 0; i<estudiantes.size(); i++){
			e = (Estudiante)estudiantes.elementAt(i);
			if(e.codigo().compareTo(codigo) > 0){
				estudiantes.insertElementAt(new Estudiante(codigo, nombre),i);
				return 0;
			}else if(e.codigo().compareTo(codigo) == 0){
				return -1;
			}
	    }
	    
	    // Si al final del Vector no encontro ningun codigo "mayor" que el
	    // que necesita agregar, agrega el estudiante al final
	    if(i == estudiantes.size()){
	    	estudiantes.add(new Estudiante(codigo,nombre));
	    	return 0;
	    }
	    return -1;
	}
	
	// Agrega los estudiantes secuencialmente en el Vector, en el orden
	// que lleguen
	public int agregarSec(String codigo, String nombre){
		Estudiante e = buscar(codigo);
		if(e != null){
			return -1;
		}
		
		estudiantes.add(new Estudiante(codigo,nombre));
		return 0;
	}
	
	// Para editar el nombre de un estudiante primero lo busca,
	// despues lo borra y lo vuelve a agregar con el nuevo nombre.
	// Esta funcion puede ser mejorada para que sea mas eficiente
	// con vectores de tamaño grande
	public int editar(String codigo, String nombre){
		int resultado = borrar(codigo);
		if(resultado == -1){
			return resultado;
		}
		agregarSec(codigo,nombre);
		return 0;
	}
	
	// Busca un estudainte por el codigo y lo remueve del Vector
	public int borrar(String codigo){
		Estudiante e;
		for(int i = 0; i < estudiantes.size(); i++){
			e = (Estudiante)estudiantes.elementAt(i);
			if(e.codigo().equals(codigo)){
				estudiantes.remove(i);
				return 0;
			}
		}
		return -1;
	}
	
	// Retorna un String con el listado de todos los alumnos en la lista
	// (Vector); String que sera utilizada para generar la ventana VLista
	public String listar(){
		Estudiante e;
		String salida = new String();
		for(int i = 0; i < estudiantes.size(); i++){
			e = (Estudiante)estudiantes.elementAt(i);
			salida = salida + e.codigo() + "\t" + e.nombre() + "\n";
		}
		return salida;
	}
}