package org.jfcmc.parsers.expr.lexer;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

import org.jfcmc.parsers.expr.tokens.Token;

public class Lexer {
    private PushbackReader line;
    private StringBuilder currentToken;
    private enum State { INITIAL, DIGITS, IDS };
    private Token lastToken;

    public class LexerException extends Exception {
        public LexerException() {
            super();
        }
        public LexerException(String message) {
            super(message);
        }
    }

    public Lexer(String line) {
        this.line = new PushbackReader(new StringReader(line));
        lastToken = null;
    }

    public Token getNextToken()
        throws LexerException, IOException {

        Token token = null;
        if (lastToken != null) {
            token = lastToken;
            lastToken = null;
            return token;
        }

        State state = State.INITIAL;
        currentToken = new StringBuilder();

        while(true) {
            int c = line.read();

            if (state == State.INITIAL) {
                switch ((char) c) {
                case '+':
                    currentToken.append((char) c);
                    return Token.PLUS;
                case '-':
                    currentToken.append((char) c);
                    return Token.MINUS;
                case '*':
                    currentToken.append((char) c);
                    return Token.TIMES;
                case '/':
                    currentToken.append((char) c);
                    return Token.DIV;
                case '(':
                    currentToken.append((char) c);
                    return Token.OPAR;
                case ')':
                    currentToken.append((char) c);
                    return Token.CPAR;
                case ' ':
                    break;
                default:
                    if (c == -1) {
                        return Token.EOF;
                    } else {
                        if (Character.isDigit((char) c)) {
                            currentToken.append((char) c);
                            state = State.DIGITS;
                        }
                        else if (Character.isAlphabetic((char) c)) {
                            currentToken.append((char) c);
                            state = State.IDS;
                        }
                        else {
                            throw new LexerException(String.format("Unknown character: %d%c", c, c));
                        }
                        break;
                    }
                }
            }
            else if (state == State.DIGITS) {
                if (Character.isDigit((char) c)) {
                    currentToken.append((char) c);
                }
                else {
                    if (c != -1) line.unread(c);
                    state = State.INITIAL;
                    return Token.NUMBER;
                }
            }
            else if (state == State.IDS) {
                if (Character.isDigit((char) c) ||
                    Character.isAlphabetic((char) c)) {
                    currentToken.append((char) c);
                }
                else {
                    if (c != -1) line.unread(c);
                    state = State.INITIAL;
                    return Token.ID;
                }
            }
        }
    }

    public String getCurrentToken() {
        return currentToken.toString();
    }

    public void returnLastToken(Token lastToken) {
        this.lastToken = lastToken;
    }
}
