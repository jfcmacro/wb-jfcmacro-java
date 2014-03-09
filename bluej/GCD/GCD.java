import Utilidades.Lista;

/**
 * Write a description of class GCD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GCD
{
    private Lista listaCDs;
    private int totalCDs;
    
    public GCD() {
        listaCDs = new Lista();
        totalCDs = 0;
    }
    
    public void adicionarCD(CD nuevo) {
        
        listaCDs.adicionarElemento(nuevo);
    }
    
    public boolean borrarCD(String titulo, String grupo) {

        for (int i = 0; i < listaCDs.obtenerTotalElementos(); i++) {
            CD elemento = (CD) listaCDs.obtenerElemento(i);
            if (elemento.obtenerTitulo().compareTo(titulo) == 0 &&
                elemento.obtenerNombreGrupo().compareTo(grupo) == 0) {
                listaCDs.eliminarElemento(elemento);
                return true;
            }
        }
        return false;
    }
    
    public CD[] buscarAño(int año) {
        Lista listaResult = new Lista();
        
        boolean encontrado = false; 
        int i = 0;
        int j = 0;
        
        while (!encontrado && i < listaCDs.obtenerTotalElementos()) {
           CD elemento = (CD) listaCDs.obtenerElemento(i);
           if (elemento.obtenerAño() == año) {
               listaResult.adicionarElemento(elemento);
           }
           i = i + 1;
        }
        
        if (listaResult.obtenerTotalElementos() == 0)
            return null;
        
        Object []lista = listaResult.obtenerArreglo();
        CD []vector = new CD[lista.length];
 
        for (i = 0; i <lista.length; i++)
            vector[i] = (CD) lista[i];
            
        return vector;
    }
}
