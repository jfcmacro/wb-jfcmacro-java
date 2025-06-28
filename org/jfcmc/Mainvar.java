// This must be compiled with a Java version < 10.
package org.jfcmc;

import static org.jfcmc.var.var;

public class Mainvar {

    public static void main(String args[]) {
	var var = var();
	if (var == null) {
	    var(new var());
	}
    }
}
