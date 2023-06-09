package org.jfcmc.parsers.expre;

public class Div extends BinExpr {
    public Div() {
    }

    public int eval() {
        return left.eval() / right.eval();
    }
}
