package org.jfcmc.concurrency.cpabp.chap02;

import java.util.Objects;

public class LazyInitialization {

    private LazyInitialization() { }

    private volatile static LazyInitialization instance = null;

    public static LazyInitialization getInstance() {
        if (Objects.isNull(instance)) {
            instance = new LazyInitialization();
        }

        return instance;
    }
}
