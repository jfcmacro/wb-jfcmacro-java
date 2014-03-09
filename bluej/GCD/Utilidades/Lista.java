package Utilidades;


/**
 * Write a description of class Lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lista
{
    private Object arreglo[];
    private int totalElementos;
    
    public Lista()
    {
        arreglo = new Object[10];
        totalElementos = 0;
    }

    public Lista(int tamaño) {
        
        if (tamaño <= 0) 
            throw new RuntimeException("Error en el parámetro");
        
        arreglo = new Object[tamaño];
        totalElementos = 0;
    }
    
    private void crecerArreglo() {
        
        Object arreglo2[] = new Object[arreglo.length * 2];
        
        for (int i = 0; i < arreglo.length; i++) {
            arreglo2[i] = arreglo[i];
        }
        
        arreglo = arreglo2;
    }
    
    public void adicionarElemento(Object elemento) {
        
        if (totalElementos == arreglo.length) 
            crecerArreglo();
        arreglo[totalElementos] = elemento;
        totalElementos = totalElementos + 1;
    }
    
    public boolean eliminarElemento(Object elemento) {
        
        int i = 0;
        boolean encontrado = false;
        while (!encontrado && i < totalElementos) {
            
            if (elemento instanceof Comparable &&
                arreglo[i] instanceof Comparable) {
                
                if (((Comparable) arreglo[i]).esIgual((Comparable) elemento)) 
                    encontrado = true;
            }   
            else if (arreglo[i].equals(elemento)) 
                encontrado = true;
            else
                i = i + 1;
        }
        
        if (encontrado) {
            for (; i < totalElementos - 1; i++) {
                arreglo[i] = arreglo[i + 1];
            }
            totalElementos = totalElementos - 1;
        }
        
        return false;
    }
    
    public int obtenerTotalElementos() {
        return totalElementos;
    }
    
    public Object obtenerElemento(int posición) {
        if (posición >= totalElementos)
            throw new RuntimeException("Error en el parámetro");
        return arreglo[posición];
    }
    
    public Object[] obtenerArreglo() {
     
        Object result[] = new Object[totalElementos];
        
        for (int i = 0; i < totalElementos; i++) {
            result[i] = arreglo[i];
        }
        
        return result;
    }
}
