// Trabajador.java
import java.util.Random;

public class Trabajador implements Runnable {

    private Semaforo sem;
    private static int nHilosEnRegionCritica = 0;

    public Trabajador(Semaforo sem) {
	this.sem = sem;
    }

    public void run() {

	Random random = new Random();

	while (true) {
	    System.out.println("Hilo trabajador: " + 
			       Thread.currentThread().toString() + 
			       " va entrar a la región crítica");
	    sem.esperar();
	    System.out.println("Hilo trabajador: " +  
			       Thread.currentThread().toString() + 
			       " dentro de la region critica");
	    nHilosEnRegionCritica++;
	    assert nHilosEnRegionCritica < 2;
	    try {
		Thread.sleep(random.nextInt(5000) + 1);
	    } catch (InterruptedException ie) { }
	    nHilosEnRegionCritica--;
	    sem.señalar();
	    System.out.println("Hilo trabajador: " +  
			       Thread.currentThread().toString() + 
			       " por fuera de la region critica");
	    
	}
    }
}
