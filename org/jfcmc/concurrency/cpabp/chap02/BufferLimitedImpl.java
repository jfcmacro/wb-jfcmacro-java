package org.jfcmc.concurrency.cpabp.chap02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferLimitedImpl implements  BufferLimited {
    private int[] buffer;
    private int elements;
    private int i_in;
    private int i_out;
    private Lock lock;
    private Condition full, empty;

    public BufferLimitedImpl(int size) {
        buffer = new int[size];
        elements = i_in = i_out = 0;
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
    }

    public void put(int value) {
        lock.lock();
        try {
            while (elements == buffer.length) {
                full.await();
            }
            buffer[i_in] = value;
            i_in = (i_in + 1) % buffer.length;
            elements++;
            empty.signal();
        }
        finally {
            lock.unlock();
        }
    }

    public int get() {
        int result = 0;
        lock.lock();
        try {
            while (elements == 0) {
                empty.await();
            }
            result = buffer[i_out];
            i_out = (i_out + 1) % buffer.length;
            elements--;
            full.signal();
        }
        finally {
            lock.unlock();
        }

        return result;
    }
}
