package org.jfcmc.parsers.expr.ast;

public class Number extends Expr {

    private int value;

    public Number(String number) {
        value = Integer.parseInt(number);
    }

    public int eval() {
        return value;
    }
}
