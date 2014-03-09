public class Candidato {

    private Partidos partido;
    private String nombre;
    private int votos;

    public Candidato(Partidos partido, String nombre, int votos) {
	this.partido = partido;
        this.nombre = nombre;
	this.votos = votos;
    }

    public String obtenerNombre() {
	return nombre;
    }

    public int obtenerVotos() {
	return votos;
    }

    public Partidos obtenerPartido() {
	return partido;
    }
}