package org.jfcmc.parsers.expr.ast;

public class Id extends Expr {

    private String id;

    public Id(String id) {
        this.id = new String(id);
    }

    public int eval() {
        return 0;
    }
}
