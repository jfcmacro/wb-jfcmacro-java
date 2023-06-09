package org.jfcmc.parsers.expre;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class App {
    public static void main(String...args) {
        String strExpr = "a+b+c";
        try {

            ExprParser parser = new ExprParser("a+b+c");

            Map<Character,Integer> ctx = Stream.of(new Object[][] {
                    { 'a', 10 },
                    { 'b', 20 },
                    { 'c', 30 }})
                .collect(Collectors.toMap(data -> (Character) data[0],
                                          data -> (Integer) data[1]));
            Expr e = parser.expr();
            System.out.println("Context: " + ctx);
            Expr.context = ctx;
            System.out.println("" + strExpr +
                               "=" + e.eval());
        } catch (ParserException pe) {
            System.err.println("Exception: " + pe);
            System.exit(1);
        }
    }
}
