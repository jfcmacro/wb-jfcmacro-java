// This must be compiled with a Java version < 10.
package org.jfcmc;

import static org.jfcmc.Var.var;

public class MainVar {

    public static void main(String args[]) {
	Var var = var();
	if (var == null) {
	    var(new Var());
	}
    }
}
