package org.jfcmc.junit;

import org.junit.Test;

public class ATest {
   @Test(expected = java.lang.IllegalArgumentException.class)
    public void method() {
        throw new IllegalArgumentException();
   }
}
