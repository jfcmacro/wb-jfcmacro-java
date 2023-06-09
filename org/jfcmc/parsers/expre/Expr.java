package org.jfcmc.parsers.expre;

import java.util.Map;

public abstract class Expr {
    static Map<Character, Integer> context;
    public abstract int eval();
}
