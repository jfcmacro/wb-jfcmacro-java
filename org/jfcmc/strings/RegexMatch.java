package org.jfcmc.strings;

public class RegexMatch {

    public static void main(String[] args) {
        String regex = ".@.";

        matchIt("a@k", regex);
        matchIt("webmaster@djojo.com", regex);
        matchIt("r@j", regex);
        matchIt("a%N", regex);
        matchIt(".@.", regex);
    }

    public static void matchIt(String str, String regex) {
        if (str.matches(regex)) {
            System.out.println(str + " matches the regex " + regex);
        }
        else {
            System.out.println(str + " does not matches the regex " + regex);
        }
    }
}
