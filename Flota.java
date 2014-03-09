import java.util.ArrayList;

public class Flota {
    private ArrayList<Destructor> destructores;
    private ArrayList<Crucero> cruceros;

    public Flota() {
	destructores = new ArrayList<Destructor>();
	cruceros     = new ArrayList<Crucero>();
    }

    public int totalMarinerosDestructores() {
	int total = 0;
	for (Destructor d : destructores) {
	    total += d.obtenerMarineros();
	}
	return total;
    }

    public int totalMarinerosCruceros() {
	int total = 0;
	for (Crucero c : cruceros) {
	    total += c.obtenerMarineros();
	}
	return total;
    }

    public int obtenerMarineros() {
	return totalMarinerosCruceros() + totalMarinerosDestructores();
    }

}