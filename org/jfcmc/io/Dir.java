package org.jfcmc.io;

import java.io.File;
import java.io.FilenameFilter;

public class Dir {
    public static void main(String[] args) {
	if (args.length != 2) {
	    System.err.println("usage: java org.jfcmc.io.Dir dirpath ext");
	    System.exit(1);
	}
	File file = new File(args[0]);
	FilenameFilter fnf = new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
		    return name.endsWith(args[1]);
					      
		}
	    };
	
	String[] names = file.list(fnf);
	for (String name : names) {
	    System.out.println(name);
	}
    }				 
}
