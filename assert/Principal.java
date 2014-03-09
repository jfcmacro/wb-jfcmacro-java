// Principal.java

public class Principal {

    public static void main(String[] args) {
	
	// Semáforo que controla una región críticia.

	Semaforo sem = new SemaforoMalo(1);

	Thread t[] = new Thread[10];

	for (int i = 0; i < t.length; i++) {
	    t[i] = new Thread(new Trabajador(sem));
	}

	for (int i = 0; i < t.length; i++) {
	    t[i].start();
	}
    }
}
