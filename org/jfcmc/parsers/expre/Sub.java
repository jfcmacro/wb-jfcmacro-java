package org.jfcmc.parsers.expre;

public class Sub extends BinExpr {
    public Sub() {
    }

    public int eval() {
        return left.eval() - right.eval();
    }
}
