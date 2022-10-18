package org.jfcmc.lambda;

public class LambdaUtilTest {
    public static void main(String[] args) {
        LambdaUtil util = new LambdaUtil();

        util.testAdder((x,y) -> x + y);

        util.testJoiner((x,y) -> x + y);

        util.testJoiner((x,y) -> x + " " + y);

        util.testJoiner((x,y) -> {
                StringBuilder sbx = new StringBuilder(x);
                StringBuilder sby = new StringBuilder(y);
                sby.reverse().append(",").append(sbx.reverse());
                return sby.toString();
            });
    }
}
