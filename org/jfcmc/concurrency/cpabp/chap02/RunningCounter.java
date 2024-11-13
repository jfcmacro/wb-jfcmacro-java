package org.jfcmc.concurrency.cpabp.chap02;

import java.util.Random;
import java.util.stream.IntStream;

public class RunningCounter {

    public static void main(String...args) {
        CounterReadWriteLock c = new CounterReadWriteLock();
        Random r = new Random();
        
        Runnable readThread = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.printf("Thread: %s value: %d%n",
                                      Thread.curentThread(), c.get());
                    sleep(r.nextInt(1000) + 1);
                }
                catch (InterruptedException ie) { }
            }
        };

        Runnable writeThread = () -> {
            

        Thread readThr1 = new Thread(readThread);
        Thread readThr2 = new Thread(readThread);

        t1.start(); t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ie) {
            // Ignore
        }

        int result = c.incrementAndGet();

        assert(result == 2001);
        System.out.println(result);
    }
}
