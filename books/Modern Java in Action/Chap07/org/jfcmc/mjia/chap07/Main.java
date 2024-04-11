package org.jfcmc.mjia.chap07;

import java.util.stream.Stream;

public class Main {

    public long sequentialSum(long n) {
	return Stream.iterate(1L, i -> i + 1)
	    .limit(n)
	    .reduce(0L, Long::sum);
    }

    public long parallelSum(long n) {
	return Stream.iterate(1L, i -> i + 1)
	    .limit(n)
	    .parallel()
	    .reduce(0L, Long::sum);
    }

    public Main() {
    }

    public static void main(String...args) {
	Main main = new Main();
	final long nl = 2490;
	System.out.printf("SequentialSum(%d)=%d%n", nl, main.sequentialSum(nl));
	System.out.printf("ParallelSum(%d)=%d%n", nl, main.parallelSum(nl));

	System.out.println("Property: " +
			   System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
    }
}
