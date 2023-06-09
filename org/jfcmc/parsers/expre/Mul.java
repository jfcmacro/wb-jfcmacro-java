package org.jfcmc.parsers.expre;

public class Mul extends BinExpr {
    public Mul() {
    }

    public int eval() {
        return left.eval() * right.eval();
    }
}
