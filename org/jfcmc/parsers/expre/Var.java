package org.jfcmc.parsers.expre;

public class Var extends Expr {
    private char c;

    public Var(char c) {
        this.c = c;
    }

    public int eval() {
        return context.get(c);
    }
}
