package org.jfcmc.concurrency.cpabp.chap02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CounterReadWriteLock {

    private int counter;
    private Lock readLock;
    private Lock writeLock;
    private ReadWriteLock lock; 

    public CounterReadWriteLock() {
        lock = new ReentrantReadWriteLock();
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    public void increment() {
        writeLock.lock();
        try {
            ++counter;
        }
        finally {
            writeLock.unlock();
        }
    }

    public int get() {
        int result = 0;
        readLock.lock();
        try {
            result = counter;
        }
        finally {
            readLock.unlock();
        }
        return result;
    }

}
