package org.jfcmc.parsers.expr.lexer;

import org.jfcmc.parsers.expr.tokens.Token;

public class Lexer {
    private String line;
    private int index;
    private String currentToken;
    private enum State { INITIAL, DIGITS };
    private Token lastToken;

    public Lexer(String line) {
        this.line = line;
        index = 0;
        lastToken = null;
    }

    public Token getNextToken() {
                    
        Token token = null;
        if (lastToken != null) {
            token = lastToken;
            lastToken = null;
            return token;
        }
        
        State state = State.INITIAL;
        currentToken = "";
        while(true) {
            if (index == line.length()) {
                return Token.EOF;
            }
            if (state == State.INITIAL) {
                if (line.charAt(index) ==  '+') {
                    index++;
                    return Token.PLUS;
                }
                if (line.charAt(index) == '-') {
                    index++;
                    return Token.MINUS;
                }
                if (line.charAt(index) == '/') {
                    index++;
                    return Token.DIV;
                }
                if (line.charAt(index) == '*') {
                    index++;
                    return Token.TIMES;
                }
                if (line.charAt(index) == ' ')
                    ;
                if (Character.isDigit(line.charAt(index))) {
                    currentToken += "" + line.charAt(index);
                    state = State.DIGITS;
                }
                if (Character.isAlphabetic(line.charAt(index))) {
                    currentToken += "" + line.charAt(index);
                    index++;
                    return Token.ID;
                }
            }
            else if (state == State.DIGITS) {
                if (Character.isDigit(line.charAt(index))) {
                    currentToken += "" + line.charAt(index);
                    state = State.DIGITS;
                }
                else {
                    return Token.NUMBER;
                }
            }
            index++;
        }
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void returnLastToken(Token lastToken) {
        this.lastToken = lastToken;
    }
}
