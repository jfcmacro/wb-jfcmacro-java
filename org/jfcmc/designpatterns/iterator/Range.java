package org.jfcmc.designpatterns.iterator;

import java.util.Iterator;

class Range implements Iterable<Integer> {
    private int low;
    private int high;
    private int step;

    public Range(int low, int high) {
        this(low, high, 1);
    }

    public Range(int low, int high, int step) {
        setValues(low, high, step);
    }

    private void testArguments() {
        if (low >= high) {
            throw new IllegalArgumentException("low must be lower than high value");
        }

        if (step == 0) {
            throw new IllegalArgumentException("Step cannot be zero");
        }
    }

    private void setValues(int low, int high, int step) {
        this.low = low;
        this.high = high;
        this.step = step;
        testArguments();
    }

    public Range(int low, int high, int step) {
        this.low = low;
        this.high = high;
        this.step = step;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = low;
            @Override
            public boolean hasNext() {
                return index < high;
            }
            @Override
            public Integer next() {
                int ret = index;
                index += step;
                return ret;
            }
        };
    }
}
