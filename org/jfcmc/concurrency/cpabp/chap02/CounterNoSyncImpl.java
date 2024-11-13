package org.jfcmc.concurrency.cpabp.chap02;

public class CounterNoSyncImpl implements Counter {

    private int counter;

    public int incrementAndGet() {
        ++counter;
        return counter;
    }

}
