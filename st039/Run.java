import co.edu.eafit.dis.st039.util.mic.*;

public class Run {

	public static void main(String []args) {
		
		Secuenciador s = new Secuenciador();

		Thread t = new Thread(s);

		t.start();

		Thread.sleep(100);

		s.stop();

	}

}
