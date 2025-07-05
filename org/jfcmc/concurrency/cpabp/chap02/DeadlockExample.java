package org.jfcmc.concurrency.cpabp.chap02;

public class DeadlockExample {

    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void entry_1() {
	synchronized(obj1) {
	    synchronized(obj2) {
		System.out.println("Inside entry 1");
	    }
	}
	System.out.println("Outside entry 1");
    }

    public void entry_2() {
	synchronized(obj1) {
	    synchronized(obj2) { // Cambiar el orden
		System.out.println("Inside entry 2");
	    }
	}
	System.out.println("Outside entry 2");
    }
}
