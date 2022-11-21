package org.jfcmc.io;

import java.io.IOException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadBytesExample2 {
    public static void main(String []args){
        try (FileInputStream fis = new FileInputStream(FileDescriptor.in);
             FileOutputStream fos = new FileOutputStream(FileDescriptor.out);) {
            byte buffer[] = new byte[256];
            int byteRead;
            while ((byteRead = fis.read(buffer)) != -1) {
                fos.write(buffer,0,byteRead);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }
}
