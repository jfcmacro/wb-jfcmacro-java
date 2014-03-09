import Utilidades.Comparable;

/**
 * Write a description of class CD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CD implements Comparable
{
    private String titulo;
    private String grupo;
    private int año;
    
    public CD(String titulo, String grupo, int año) {
        this.titulo = titulo;
        this.grupo = grupo;
        this.año = año;
    }
    
    public String obtenerTitulo() {
        return titulo;
    }
    
    public String obtenerNombreGrupo() {
        return grupo;
    }
    
    public int obtenerAño() {
        return año;
    }
    
    public boolean esMenor(Comparable c) {
        if (c instanceof CD) {
           if (grupo.compareTo(((CD) c).grupo) < 0) {
               return true;
           }
           else {
               return false;
           }
       }
       return false;
    }
    
    public boolean esMayor(Comparable c) {
        
        if (c instanceof CD) {
            if  (grupo.compareTo(((CD) c).grupo) > 0) {
                return true;
           }
           else {
               return false;
           }
       }
       return false;
    }
    
    public boolean esIgual(Comparable c) {
        
        if (c instanceof CD) {
            if  (grupo.compareTo(((CD) c).grupo) == 0) {
                return true;
           }
           else {
               return false;
           }
       }
       return false;
    }
    
    public boolean esMenorOIgual(Comparable c) {
        
        if (c instanceof CD) {
            if  (esIgual(c) || esMenor(c)) {
                return true;
           }
           else {
               return false;
           }
       }
       return false;
    }

    public boolean esMayorOIgual(Comparable c) {
        
        if (c instanceof CD) {
            if  (esIgual(c) || esMayor(c)) {
                return true;
           }
           else {
               return false;
           }
       }
       return false;
    }
}
