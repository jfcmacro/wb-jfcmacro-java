package org.jfcmc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ChangeLogs.class)
public @interface ChangeLog {
    String date();
    String comments();
}
