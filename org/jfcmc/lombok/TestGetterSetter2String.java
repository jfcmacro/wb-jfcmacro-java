package org.jfcmc.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class TestGetterSetter2String {
    private @Getter @Setter int value;
    private @Getter @Setter String name;

    public TestGetterSetter2String(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
