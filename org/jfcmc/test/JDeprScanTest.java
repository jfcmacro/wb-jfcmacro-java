package org.jfcmc.test;

public class JDeprScanTest {
    public static void main(String...args) {

        Thread t = new Thread(() -> System.out.println("Thread"));

        t.start();
        t.stop();
    }
}
