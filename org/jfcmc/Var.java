// This must be compiled with a Java version < 10.
package org.jfcmc;

public class Var {
    private static Var var = null;

    public static Var var() {
	return var;
    }

    public static void var(Var var) {
	Var.var = var;
    }
}
