package org.jfcmc.parsers.expr;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.jfcmc.parsers.expr.tokens.Token;
import org.jfcmc.parsers.expr.lexer.Lexer;
import org.jfcmc.parsers.expr.parser.Parser;
import org.jfcmc.parsers.expr.ast.Expr;

public class Main {

    private static void onlyLexer(String expr) {
        Lexer lexer = new Lexer(expr);

        System.out.println("Lexer expr: " + expr);
        try {
            for (Token tkn = lexer.getNextToken();
                 tkn != Token.EOF;
                 tkn = lexer.getNextToken()) {
                System.out.print("Token: " + tkn.name());
                System.out.println(" value: " + lexer.getCurrentToken());
            }
        } catch (Lexer.LexerException | IOException e) {
            System.err.println("Because: " + e);
        }
    }

    private static void evalExpr(String expr) {
        try {
            Lexer lexer = new Lexer(expr);
            Parser parser = new Parser(lexer);
            Expr e = parser.e();
            System.out.printf("The expression %s value is %d%n", expr, e.eval());
        } catch (Parser.ParserException e) {
            System.err.printf("Not valid expression: %s%n", expr);
            System.err.println("Because: " + e);
        } catch (Lexer.LexerException | IOException e) {
            System.err.printf("Not valid token");
            System.err.println("Because: " + e);
        } 
    }

    private static String[] exprs = { "1",
        "2 + 3",
        "a",
        "2 + 3 * 4",
        "(2 + 3) * 4" };

    public static void main(String...args) {
        List<Consumer<String>> consumers = Arrays.asList(Main::onlyLexer,
                                                         Main::evalExpr);

        int index = args.length == 0 ? args.length : args.length / args.length;

        Arrays.asList(exprs)
            .stream()
            .forEach(consumers.get(index));
    }
}
