package org.jfcmc.io;

import java.io.File;
import java.util.Date;

public class FileDirectoryInfo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage: java org.jfcmc.io.FileDirectoryInfo pathname");
            System.exit(1);
        }
        File file = new File(args[0]);
        System.out.println("About " + file + ":");
        System.out.println("Exists = " + file.exists());
        System.out.println("Is directory = " + file.isDirectory());
        System.out.println("Is file =  " + file.isFile());
        System.out.println("Is hidden = " + file.isHidden());
        System.out.println("Last Modified = " +
                           new Date(file.lastModified()));
        System.out.println("Length =  " + file.length());
    }
}
