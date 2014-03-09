import java.util.Random;


public class MultiplesHilos extends Thread {

    static Thread conjuntoThread[] = new Thread[10];

    public MultiplesHilos() { }

    public void run() {

	Random rand = new Random();

	int valorAEsperar = rand.nextInt(8000);

	try {
	    Thread.sleep(valorAEsperar);
	} catch (InterruptedException ie) { }

	System.out.println("Termine: " + Thread.currentThread());
    }

    public static void main(String []args) {

	try {
	    for (int i = 0; i < conjuntoThread.length; i++) {
		conjuntoThread[i] = new MultiplesHilos();
		conjuntoThread[i].start();
		System.out.println("Inicio: " + conjuntoThread[i]);
	    }
	    
	    for (int i = 0; i < conjuntoThread.length; i++) {
		conjuntoThread[i].join();
	    }
	} catch (Exception e) {
	    System.err.println(e);
	    System.exit(1);
	}

    }		
}
