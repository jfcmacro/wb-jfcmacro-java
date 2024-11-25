package org.jfcmc.concurrency.jcip.chap03;

import lombok.Getter;
import lombok.Setter;

/**
 * From book Java Concurrency in Practice Chapter 3. Sharing Data
 * This version is a new version using package lombok to manage automatically
 * setters and getters.
 *
 */
public class MutableIntegerLombok {
    private @Getter @Setter int mutable;
}
