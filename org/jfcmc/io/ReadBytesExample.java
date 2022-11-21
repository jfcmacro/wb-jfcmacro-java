package org.jfcmc.io;

import java.io.IOException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadBytesExample {
    public static void main(String []args){
        try (FileInputStream fis = new FileInputStream(FileDescriptor.in);
             FileOutputStream fos = new FileOutputStream(FileDescriptor.out);) {
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }
}
