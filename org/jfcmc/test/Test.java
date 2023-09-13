package org.jfcmc.test;

public class Test {
    private int value;
    public Test(int value) {
        this.value = value;
    }

    public Test(Integer value) {
        this.value = value;
    }

    public Test(int value1, Integer value2) {
        this.value = value1 + value2;
    }

    @Override
    public String toString() {
        return "Test: " + value;
    }
}
