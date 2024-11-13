package org.jfcmc.lombok;

import lombok.Getter;
import lombok.Setter;

public class TestSetter {
    private @Getter @Setter int value;
    private @Getter @Setter String name;

    public TestSetter(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
