package org.jfcmc.concurrency.cpabp.chap02;

public class CounterSyncImpl implements Counter {

    private int counter;

    public synchronized int incrementAndGet() {
        ++counter;
        return counter; 
    }

}
