public class Crucero {

    private String nombre;
    private int marineros;

    public Crucero(String nombre, int marineros) {
	this.nombre = nombre;
	this.marineros = marineros;
    }

    public int obtenerMarineros() {
	return marineros;
    }
    public String obtenerNombre() {
	return nombre;
    }

}