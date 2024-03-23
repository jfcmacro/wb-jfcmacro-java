package org.jfcmc.parsers.expr.ast;

import java.util.function.BiFunction;

public class BinOper extends Expr {

    private String id;
    private BiFunction<Integer,Integer,Integer> function;
    private Expr left;
    private Expr right;

    public BinOper(Expr left, Expr right,
                   BiFunction<Integer,Integer,Integer> function) {
        this.left = left;
        this.right = right;
        this.function = function;
    }

    public int eval() {
        return function.apply(left.eval(), right.eval());
    }
}
