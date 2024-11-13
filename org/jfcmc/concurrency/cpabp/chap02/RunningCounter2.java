package org.jfcmc.concurrency.cpabp.chap02;

import java.util.Random;
import java.util.stream.IntStream;

public class RunningCounter2 {

    public static void main(String...args) {
        CounterReadWriteLock c = new CounterReadWriteLock();
        Random r = new Random();

        Runnable readThread = () -> {
            IntStream.iterate(0, i -> i < 100, i -> i + 1)
            .forEach(i -> {
                    try {
                        System.out.printf("Thread: %s value: %d%n",
                                          Thread.currentThread(), c.get());
                        Thread.sleep(r.nextInt(200) + 1);
                    }
                    catch (InterruptedException ie) { }
                });
        };

        Runnable writeThread = () -> {
            IntStream.iterate(0, i -> i < 1000, i -> i + 1)
            .forEach(i -> {
                    try {
                        c.increment();
                        Thread.sleep(r.nextInt(100) + 1);
                    }
                    catch (InterruptedException ie) { }
                });
        };

        Thread readThr1 = new Thread(readThread);
        Thread readThr2 = new Thread(readThread);
        Thread writeThr1 = new Thread(writeThread);
        Thread writeThr2 = new Thread(writeThread);

        readThr1.start(); readThr2.start();
        writeThr1.start(); writeThr2.start();

        try {
            readThr1.join();
            readThr2.join();
            writeThr1.join();
            writeThr2.join();
        } catch (InterruptedException ie) {
            // Ignore
        }

        int result = c.get();

        System.out.println(result);
    }
}
