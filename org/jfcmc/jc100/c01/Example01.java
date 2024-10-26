package org.jfcmc.jc100.c01;

public class Example01 {

    static String reverseString(final String input) {
        if (input.length() <= 1) {
            return input;
        }

        final char firstChar = input.charAt(0);
        final String remaining = input.substring(1);

        return reverseString(remaining) + firstChar;
    }
}
