import javax.swing.JFrame;

public class CountDown 
    implements Runnable {

    JFrame frame;
    Thread counter;
    int i;
    final static int N = 10;
    AudioClip beepSound, tickSound;
    NumberCanvas display;

    public void init() {
	frame = new JFrame("Countdown");
    }

    public void start() {
	counter = new Thread(this);
	i = N;
	counter.start();
    }

    public void stop() {
	counter = null;
    }

    public void run() {
	while (true) {
	    if (counter == null) return;
	    if (i>0) { tick(); --i; }
	    if (i==0) { beep(); return; }
	}
    }

    private void tick() {
	display.setvalue(i);
	tickSound.play();
	try {
	    Thread.sleep(1000);
	}
	catch (InterruptedException e) {
	}
    }

    private void beep() {
	display.setvalue(i);
	beepSound.play();
    }
}
