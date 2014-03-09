
/* 
 * Author: Juan Francisco Cardona Mc'Cormick
 * Date:   05/04/2007
 *
 */ 

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MalFormedBadFilenames {

    public class NoDirnameException extends Exception {
       
	public NoDirnameException() {
	    super("No dirname");
	}
	public NoDirnameException(String s) {
	    super(s);
	}
    }

    public void process(String initialDir) 
	throws NoDirnameException {
	File fDir = new File(initialDir);

	if (!fDir.isDirectory()) {
	    throw new NoDirnameException();
	}

	String listFilenames[] = fDir.list();
	
	for (int i = 0; i < listFilenames.length; i++) {
	    File fchild = new File(initialDir + "/" + listFilenames[i]);
	    if (fchild.isDirectory()) {
		try {
		    new MalFormedBadFilenames().process(fchild.getPath());
		} catch (NoDirnameException nde) {
		    System.err.println("Problemas with: " + fchild.getName());
		}
	    }
	    else {
		try {
		    FileReader fr = new FileReader(fchild);
		    fr.close();
		} catch (FileNotFoundException fnfe) {
		    System.err.println(""+fnfe+ " " + " open " + 
				       fchild.getName());
		} catch (IOException ioe) {
		    System.err.println(""+ ioe + " no expected ");
		}
	    }
	}
    }

    public static void main(String args[]) {

	if (args.length != 1) {
	    System.err.println("Usage: MalFormedBadFilenames <initialDir>");
	    System.exit(1);
	}
	try {
	    new MalFormedBadFilenames().process(args[0]);
	} catch (NoDirnameException nde) {
	    System.err.println("Usage: MalFormedBadFilenames <initialDir>");
	    System.err.println("Error: incorrect dirname");
	    System.exit(1);
	}
    }
}
