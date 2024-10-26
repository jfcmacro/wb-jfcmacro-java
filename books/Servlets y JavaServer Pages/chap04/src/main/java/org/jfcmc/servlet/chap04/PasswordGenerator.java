package org.jfcmc.servlet.chap04;

import java.util.Properties;
import java.io.FileOutputStream;

public class PasswordGenerator {

    public static void main(String...args) throws Exception {
        Properties passwords = new Properties();

        passwords.put("antonio", "ctsantonio");
        passwords.put("bj", "ctsbj");
        passwords.put("ileana", "ctsileana");
        passwords.put("fernando", "ctsfernando");

        String passwordsFile = "passwords.properties";

        FileOutputStream out = new FileOutputStream(passwordsFile);

        passwords.store(out, "Passwords");
    }
}
