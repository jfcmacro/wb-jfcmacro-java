package org.jfcmc.strings;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternMatcher {

    public static void main(String[] args) {
        String regex = "[abc]@.";

        String source = "cric@jdojo.com is a valid email address";
        findPattern(regex, source);

        source = "kelly@jdojo.com is invalid";
        findPattern(regex, source);

        source = "a@band@yea@u";
        findPattern(regex, source);

        source = "There is an @ sign here";
        findPattern(regex, source);
    }

    public static void findPattern(String regex, String source) {
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(source);

        System.out.println("\nRegex:" + regex);
        System.out.println("Text:" + source);

        boolean found = false;

        while (m.find()) {
            System.out.println("Matched Text:" + m.group() +
                               ", Start:" + m.start() +
                               ", " + " End:" + m.end());
            found = true;
        }

        if (!found) {
            System.out.println("No match found");
        }
    }
}
