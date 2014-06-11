import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class Planeta {

    private int distancia;
    private double angulo;

    public Planeta(int distancia) {
	this.distancia = distancia;
	this.angulo = distancia;
    }

    public int getDistancia() {
	return distancia;
    }

    public double getAngulo() {
	return angulo;
    }

    public void cambio(int x) {
        angulo += x;
    }
}

public class EjemploMapa {

    private Map<String,Planeta> planetas;

    public EjemploMapa() {
	planetas = new HashMap<String, Planeta>();

	planetas.put("Mercurio", new Planeta(1));
	planetas.put("Venus", new Planeta(2));
	planetas.put("Tierra", new Planeta(3));
	planetas.put("Marte", new Planeta(4));
    }

    public void hacerCambio() {

	Set<String> nombres = planetas.keySet();
	int i = 10;
	for (String nom : nombres) {
	    Planeta p = planetas.get(nom);
	    p.cambio(i);
	    System.out.println(nom + " : " + p.getAngulo());
	}
    }

    public static void main(String args[]) {

	EjemploMapa ej = new EjemploMapa();

	for (int i = 0; i < 10; i++) {
	    ej.hacerCambio();
	}
    }
}
