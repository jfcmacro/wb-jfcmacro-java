package org.jfcmc.concurrency.jcip.chap03;

import lombok.Synchronized;

/**
 * From book Java Concurrency in Practice Chapter 3. Sharing Data
 *
 */
public class SynchronizedIntegerLombok {
    private int mutable;

    @Synchronized
    public int get() { return mutable; }
    @Synchronized
    public void set(int mutable) { this.mutable = mutable; }
}
