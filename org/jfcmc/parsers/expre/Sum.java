package org.jfcmc.parsers.expre;

public class Sum extends BinExpr {
    public Sum() {
    }

    public int eval() {
        return left.eval() + right.eval();
    }
}
