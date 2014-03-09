import java.util.ArrayList;

public class Eleccion {
    private ArrayList<Candidato> candidatos;
    private int[]     partidos;

    public Eleccion() {
	candidatos = new ArrayList<Candidato>();
	int i = 0;
	for (Partidos p : Partidos.values()) {
	    i++;
	}
	partidos   = new int[i];
    }

    public void mostrarResultadosPartidos() {
	int totalVotos = 0;
	for (Candidato c : candidatos) {
	    int votos = c.obtenerVotos();
	    totalVotos += votos;
	    partidos[c.obtenerPartido().ordinal()] += votos;
	}
	for (Partidos p : Partidos.values()) {
	    System.out.println("Partido: " + p + " votos: " + partidos[p.ordinal()] 
			       + " porcentaje: " + (partidos[p.ordinal()] / totalVotos));
	}
    }
}