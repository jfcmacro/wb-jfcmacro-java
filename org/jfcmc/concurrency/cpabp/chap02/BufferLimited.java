package org.jfcmc.concurrency.cpabp.chap02;

public interface BufferLimited {
    void put(int value);
    int get();
}
