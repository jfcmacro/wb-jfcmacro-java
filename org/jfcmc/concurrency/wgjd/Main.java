package org.jfcmc.concurrency.wgjd;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String...args)
	throws InterruptedException {
	
	var latch = new CountDownLatch(5);
	var count = new AtomicInteger();
	for (int i = 0; i < 5; i = i + 1) {
	    var r  = new Counter(latch, i, count);
	    new Thread(r).start();
	}
    
	latch.await();
	System.out.println("Total: "+ count.get());
    }
}
