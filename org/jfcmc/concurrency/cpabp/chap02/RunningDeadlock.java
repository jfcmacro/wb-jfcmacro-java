package org.jfcmc.concurrency.cpabp.chap02;


public class RunningDeadlock {

    public static void main(String...args) {

	DeadlockExample de = new DeadlockExample();

	Runnable run1 = () -> {
	    while (true) de.entry_1();
	};

	Runnable run2 = () -> {
	    while (true) de.entry_2();
	};
	
        Thread thr1 = new Thread(run1);
        Thread thr2 = new Thread(run2);

        thr1.start(); thr2.start();

        try {
            thr1.join();
            thr2.join();
        }
	catch (InterruptedException ie) {
            // Ignore
        }
    }
}
