import java.util.ArrayList;

public class Marina {

    private ArrayList<Flota> flotas;

    public Marina() {
	flotas = new ArrayList<Flota>();
    }
   
    public int totalMarineros() {
	int total = 0;
	for (Flota flota : flotas) {
	    total += flota.obtenerMarineros();
	}
	return total;
    }
}