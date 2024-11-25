package org.jfcmc.concurrency.jcip.chap03;

import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;

/**
 * From book Java Concurrency in Practice Chapter 3. Sharing Data
 *
 * This is a bad idea. The class is not completely synchronized
 */
public class SynchronizedIntegerLombok2 {
    private @Getter @Setter int mutable;

    @Synchronized
    public int get() { return getMutable(); }

    @Synchronized
    public void set(int mutable) { setMutable(mutable); }
    // public int get() { return mutable; }
    // @Synchronized
    // public void set(int mutable) { this.mutable = mutable; }
}
