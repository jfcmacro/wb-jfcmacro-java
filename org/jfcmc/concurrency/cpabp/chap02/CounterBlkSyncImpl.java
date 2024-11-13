package org.jfcmc.concurrency.cpabp.chap02;

public class CounterBlkSyncImpl implements Counter {

    private int counter;

    public int incrementAndGet() {
        int result = 0;
        synchronized(this) {
            result = ++counter;
        }
        return result;
    }

}
