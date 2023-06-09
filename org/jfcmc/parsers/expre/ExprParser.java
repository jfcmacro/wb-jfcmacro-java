package org.jfcmc.parsers.expre;

public class ExprParser {

    private StringBuilder scan;
    private int pos;

    public ExprParser(String input) {
        this.scan = new StringBuilder(input);
        this.pos = 0;
    }

    public Expr expr() throws ParserException {
        Expr le = fact();
        return exprP(le);
    }

    public Expr exprP(Expr le) throws ParserException {
        if (pos == scan.length()) {
            return le;
        }
        char c = scan.charAt(pos);
        Expr e = null;
        switch(c) {
        case '+':
            e = new Sum();
            pos++;
            break;
        case '-':
            e = new Sub();
            pos++;
            break;
        case '*':
            e = new Mul();
            pos++;
            break;
        case '/':
            e = new Div();
            pos++;
            break;
        default:
            e = le;
            break;
        }
        if (e != null) {
            Expr re = fact();
            ((BinExpr) e).setLeftExpr(le);
            ((BinExpr) e).setRightExpr(re);
        }
        return exprP(e);
    }

    public Expr fact() throws ParserException {
        char c = scan.charAt(pos);
        Expr e = null;
        if (c >= 'a' && c <= 'z') {
            pos++;
            e = new Var(c);
        }
        else if (c == '(') {
            pos++;
            e = expr();
            c = scan.charAt(pos);
            if (c == ')') {
                pos++;
            }
            else {
                throw new ParserException();
            }
        }
        else {
            throw new ParserException();
        }
        return e;
    }
}
