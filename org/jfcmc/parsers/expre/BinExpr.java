package org.jfcmc.parsers.expre;

public abstract class BinExpr extends Expr {
    protected Expr left;
    protected Expr right;
    public void setLeftExpr(Expr left) {
        this.left = left;
    }
    public void setRightExpr(Expr right) {
        this.right = right;
    }
}
