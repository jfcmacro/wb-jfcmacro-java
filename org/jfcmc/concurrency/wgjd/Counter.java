package org.jfcmc.concurrency.wgjd;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable {
    private final CountDownLatch latch;
    private final int value;
    private final AtomicInteger count;
 
    public Counter(CountDownLatch l, int v, AtomicInteger c) {
	this.latch = l;
	this.value = v;
	this.count = c;
    }
 
    @Override
    public void run() {
	try {
	    Thread.sleep(100);
	} catch (InterruptedException e) {
	    Thread.currentThread().interrupt();
	}
	count.addAndGet(value);
	latch.countDown();
    }
}
