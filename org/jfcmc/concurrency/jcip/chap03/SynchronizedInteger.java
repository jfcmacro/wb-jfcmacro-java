package org.jfcmc.concurrency.jcip.chap03;

/**
 * From book Java Concurrency in Practice Chapter 3. Sharing Data
 *
 */
public class SynchronizedInteger {
    private int mutable;

    public synchronized int get() { return mutable; }
    public synchronized void set(int mutable) { this.mutable = mutable; }
}
