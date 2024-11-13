package org.jfcmc.concurrency.cpabp.chap02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLockImpl implements Counter {

    private int counter;
    private Lock lock;

    public CounterLockImpl() {
        lock = new ReentrantLock();
    }

    public int incrementAndGet() {
        int result = 0;
        lock.lock();
        try {
            result = ++counter;
        }
        finally {
            lock.unlock();
        }
        return result;
    }

}
