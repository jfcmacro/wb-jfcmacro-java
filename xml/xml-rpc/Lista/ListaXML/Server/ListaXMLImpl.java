package ListaXML.Server;

import java.util.*;
import ListaXML.IListaXML;

public class ListaXMLImpl implements IListaXML {
   
    private Map lista;
    
    public ListaXMLImpl() {
	lista = new Hashtable();
    }
    
    public boolean adicionar(String nombre) {
	
	if (lista.containsKey(nombre))
	    return false;

	lista.put(nombre, nombre);
	return true;
    }
    
    public boolean borrar(String nombre) {

	if (lista.remove(nombre) == null) {
	    return false;
	}

	return true;
    }

    public boolean consultar(String nombre){
	
	if (lista.containsKey(nombre)) 
	    return true;

	return false;
    }
}
