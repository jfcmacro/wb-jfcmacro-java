package org.jfcmc.concurrency.cpabp.chap02;

import java.util.Random;
import java.util.stream.IntStream;

public class RunningCounter3 {

    public static void main(String...args) {
	Counter cc = null;
	if (args.length == 0) {
        cc = new CounterNoSyncImpl();
	}
	else {
	    switch(args[0]) {
	    case "blk": 
		cc = new CounterBlkSyncImpl();
		break;
	    case "mth":
		cc = new CounterSyncImpl();
		break;
	    case "lck":
		cc = new CounterLockImpl();
		break;
		
	    default:
		cc = new CounterNoSyncImpl();
	    }
	}

	final Counter c = cc;
        Runnable run = () -> {
            for (int i = 0; i < 10000; i++) {
		c.incrementAndGet();
            }
        };
	
        Thread thr1 = new Thread(run);
        Thread thr2 = new Thread(run);

        thr1.start(); thr2.start();

        try {
            thr1.join();
            thr2.join();
        }
	catch (InterruptedException ie) {
            // Ignore
        }

        int result = c.incrementAndGet();
	
        System.out.println(result);
        assert(result == 20001);
    }
}
