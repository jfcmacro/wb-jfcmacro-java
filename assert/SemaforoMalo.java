// SemaforoMalo.java

public class SemaforoMalo implements Semaforo {

    private int count = 0;

    public SemaforoMalo(int count) {
	this.count = count;
    }

    public synchronized void esperar() {

    }

    public synchronized void señalar() {

    }
}
