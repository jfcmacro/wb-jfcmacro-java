package org.jfcmc.lombok;

import lombok.Getter;

public class TestGetter {
    private @Getter int value;
    private @Getter String name;

    public TestGetter(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
