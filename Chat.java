import java.util.Scanner;

public class Chat {

    public static void main(String...args) {
        Scanner scanLocal = new Scanner(System.in);
        Socket s = ...;
        Scanner scanRemote = new Scanner(s.getInputStream());
        Object o = new Object(); // wait(); notify(); notifyAll();
                   
        Threat t = new Thread(() -> {
                do {
                    String lineOtro = scanRemote.nextLine();
                    // Region Critica
                    synchronized(o) {
                       System.out.println("Otro: " + line); // <<--
                    }
                    // 
                    if (line.isEmpty()) break;
                } while (true);
        });

        t.start(); // Hay dos hilos.
        // 
        do {
            String line = scanLocal.nextLine();
            // Region Critica
            synchronized(o) {
                System.out.println("Yo: " + line); // <<--
            }
            // 
            if (line.isEmpty()) break;
        } while (true);
        t.join();
    }
}
