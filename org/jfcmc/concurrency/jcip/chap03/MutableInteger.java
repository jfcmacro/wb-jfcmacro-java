package org.jfcmc.concurrency.jcip.chap03;

/**
 * From book Java Concurrency in Practice Chapter 3. Sharing Data
 *
 */
public class MutableInteger {
    private int mutable;

    public int get() { return mutable; }
    public void set(int mutable) { this.mutable = mutable; }
}
