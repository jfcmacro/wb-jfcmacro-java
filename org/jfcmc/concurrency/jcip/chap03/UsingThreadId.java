package org.jfcmc.concurrency.jcip.chap03;

import java.util.stream.IntStream;

public class UsingThreadId {

    public static void main(String...args) {
        Runnable r = () -> {
            int id = ThreadId.get();
            System.out.println("ThreadId: " + id +
                               " thread: " + Thread.currentThread().getId());
        };

        IntStream.range(0,100)
            .forEach(i -> new Thread(r).start());
    }
}
