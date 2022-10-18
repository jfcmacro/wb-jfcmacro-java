
class RunForever implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Running againg");
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                System.out.println("I was interrupted: " + ie);
            }
        }
    }
}

public class ThreadRunning {

    public static void main(String args[]) {

        Thread thisThread = Thread.currentThread();
        thisThread.setName("ThreadRunning");
        Thread other = new Thread(new RunForever(), "RunForever");
        other.setDaemon(true);
        other.start();
        System.out.println("" + thisThread.getName() + " is running");
        try { Thread.sleep(1000); } catch (InterruptedException ie) { }
        System.out.println("" + thisThread.getName() + " is running");
        try { Thread.sleep(1000); } catch (InterruptedException ie) { }
        System.out.println("" + thisThread.getName() + " is running");
        try { Thread.sleep(1000); } catch (InterruptedException ie) { }
        System.out.println("" + thisThread.getName() + " is running");
        try { Thread.sleep(1000); } catch (InterruptedException ie) { }
    }
}
