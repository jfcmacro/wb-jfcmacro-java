public class Candidato {

    private Partido partido;
    private String nombre;
    private int votos;

    public Candidato(Partido partido, String nombre, int votos) {
	this.partido = partido;
        this.nombre = nombre;
	this.votos;
    }

    public String obtenerNombre() {
	return nombre;
    }

    public int obtenerVotos() {
	return votos;
    }

    public Partido obtenerPartido() {
	return partido;
    }
}