
import Semaphore.*;
import java.util.Random;

public class Pulso {
    
    public static void main(String args[]) {

	Semaphore []semArray = new SemaphoreImplementation[8];
	
	for (int i = 0; i < 8; i++) {
	    semArray[i] = new SemaphoreImplementation(0);
	}
	
	(new Thread(new HiloControl(semArray))).start();
	(new Thread(new HiloNodo(semArray[0], semArray[4]))).start();
	(new Thread(new HiloNodo(semArray[1], semArray[5]))).start();
	(new Thread(new HiloNodo(semArray[2], semArray[6]))).start();
	(new Thread(new HiloNodo(semArray[3], semArray[7]))).start();
    }
       
}

class HiloControl implements Runnable {


    Semaphore []semArray;

    HiloControl(Semaphore []semArray) {
	this.semArray = semArray;
    }
       
    public void run() {

       while (true) {

           try { Thread.sleep(4000); } catch (InterruptedException ie) { }
           System.out.println("Voy a despertar a los nodos");
	   for (int i = 0; i < 4; i++) {
	       semArray[i].semSignal();
	   }
           System.out.println("Voy a esperar a los nodos");
	   for (int i = 4; i < 8; i++) {
	       semArray[i].semWait();
	   }

       }
        
    }

}

class HiloNodo implements Runnable {

   Semaphore sCN;
   Semaphore sNC;

   HiloNodo(Semaphore sCN, Semaphore sNC) {
      this.sCN = sCN;
      this.sNC = sNC;
   }

   public void run() {

        while (true) {

           sCN.semWait();
           System.out.println("Estoy vivo: " + this);
	   try { 
	       Random r = new Random(System.currentTimeMillis());
	       Thread.sleep(r.nextInt(10000));
	   } catch (InterruptedException ie) { }
           sNC.semSignal();
        }
   }
}
