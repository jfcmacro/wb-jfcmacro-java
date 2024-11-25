package org.jfcmc.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Main {

    public static void main(String...args) {

        JUnitCore junit = new JUnitCore();

        Result res = junit.run(ATest.class);

        System.out.printf("Count: %d failed: %d%n",
                          res.getRunCount(), res.getFailureCount());

        res = junit.run(OtherTest.class);

        System.out.printf("Count: %d failed: %d%n",
                          res.getRunCount(), res.getFailureCount());

    }
}
