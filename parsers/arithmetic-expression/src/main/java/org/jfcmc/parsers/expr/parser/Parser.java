package org.jfcmc.parsers.expr.parser;

import java.io.IOException;

import org.jfcmc.parsers.expr.ast.BinOper;
import org.jfcmc.parsers.expr.ast.Expr;
import org.jfcmc.parsers.expr.ast.Id;
import org.jfcmc.parsers.expr.ast.Number;
import org.jfcmc.parsers.expr.lexer.Lexer;
import org.jfcmc.parsers.expr.tokens.Token;

public class Parser {

    public class ParserException extends Exception {
        public ParserException() {
            super();
        }
        public ParserException(String message) {
            super(message);
        }
    }

    private Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public Expr expr()
        throws Parser.ParserException,
               Lexer.LexerException, IOException {
        Expr e = e();
        Token tkn = lexer.getNextToken();
        if (tkn != Token.EOF) {
            throw new Parser.ParserException("Expr expected EOF found: " +
                                             tkn.name());
        }
        return e;
    }

    public Expr e()
        throws Parser.ParserException,
               Lexer.LexerException, IOException {
        // E := T E'
        Expr t = t();
        return ep(t);
    }

    public Expr ep(Expr e)
        throws Parser.ParserException,
               Lexer.LexerException, IOException {
        Expr r = null;
        Token tkn = lexer.getNextToken();
        // + T E' | - T E'
        if (tkn == Token.PLUS || tkn == Token.MINUS) {
            Expr t = t();
            Expr ep = ep(t);
            r = new BinOper(e, ep, tkn == Token.PLUS ?
                            (x,y) -> x + y :
                            (x,y) -> x - y);
        }
        else if (tkn == Token.EOF ||
                 tkn == Token.CPAR) {
            lexer.returnLastToken(tkn);
            r = e;
        }
        else {
            throw new ParserException("ep at: " + tkn.name());
        }
        return r;
    }

    public Expr t()
        throws Parser.ParserException,
               Lexer.LexerException, IOException {
        // T := F T'
        Expr f = f();
        return tp(f);
    }

    public Expr tp(Expr e)
        throws Parser.ParserException,
               Lexer.LexerException, IOException {
        Token tkn = lexer.getNextToken();
        Expr r = null;
        if (tkn == Token.TIMES || tkn == Token.DIV) {
            Expr f = f();
            Expr tp = tp(f);
            r = new BinOper(e, tp, tkn == Token.TIMES ?
                            (x,y) -> x * y :
                            (x,y) -> x / y);
        }
        else if (tkn == Token.EOF  ||
                 tkn == Token.CPAR ||
                 tkn == Token.PLUS ||
                 tkn == Token.MINUS) {
            lexer.returnLastToken(tkn);
            r = e;
        }
        else {
            throw new ParserException("tp at: " + tkn.name());
        }

        return r;
    }

    public Expr f()
        throws Parser.ParserException,
               Lexer.LexerException, IOException {
        Token tkn = lexer.getNextToken();
        if (tkn == Token.NUMBER) { // f := Number
            return new Number(lexer.getCurrentToken());
        }

        if (tkn == Token.ID) { // f := ID
            return new Id(lexer.getCurrentToken());
        }

        Expr e = null;
        if (tkn == Token.OPAR) { // f ::= ( e )
            e = e();
            tkn = lexer.getNextToken();
            if (tkn != Token.CPAR) {
                throw new ParserException("f expected ) found: " + tkn.name());
            }
        }
        else {
            throw new ParserException("f expected NUMBER, ID , ( found: " +
                                      tkn.name());
        }

        return e;
    }
}
