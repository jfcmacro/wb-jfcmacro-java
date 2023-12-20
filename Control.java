

public class Control implements ThreadFactory  {

    private AtomicInteger nThreads;
    private List<Result> result;
    private enum ESTADO { INICIANDO, SHUTDOWN, FINISHED };

    public Control() {
        result = ...;
        ESTADO estado = INICIANDO;
    }
    
    public Thread newThread(Runnable r) {
        if (estado == INICIANDO) {
            Runnable miRunnable = () -> {
            // Antes de ejecutar el hilo
            // synchronized(this) {
            //     nThreads++;
            // }
                nThreads.increment();
                // Ejecutar el hilo interno
            try {
                r.run();
            } catch (Throwable t) {
            } finally {
            }
            // synchronized(this) {
            //     nThreads--;
            // }
            nThreads.decrement();
            synchronized(this) {
                if (nThread == 0) notifyAll();
            }
            // Despues de ejecutar el hilo.
        };

        return new Thread(miRunnable);
        }
        else {
            return null;
        }
    }

    public int nThreads() {
        return nThreads.get();
    }

    public synchronized void awaitTermination() {
        while (nThreads > 0) {
            try {
                wait();
            } catch (InterruptedException ie) { }
        }
    }
}
