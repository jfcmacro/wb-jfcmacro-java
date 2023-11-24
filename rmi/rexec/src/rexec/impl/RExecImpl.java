package rexec.impl;

import rexec.inter.RExec;
import java.lang.ProcessBuilder; // Esto no es necesario pero solo es para control
import java.lang.Process;
import java.io.IOException;
import java.lang.InterruptedException;

public class RExecImpl implements RExec {

    public Integer compile(String path, String sourceName) {
	try {

	    Process comp = new ProcessBuilder("javac", path + "/" + sourceName).start();
	    return Integer.valueOf(comp.waitFor());
	} 
	catch (IOException e) {
	    return Integer.valueOf(-1);
	}
	catch (InterruptedException e) {
	    return Integer.valueOf(-1);
	}
    }
}
