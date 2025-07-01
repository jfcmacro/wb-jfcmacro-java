package org.jfcmc.servlet.chap05;

import static java.util.stream.Collectors.joining;

public class ServletUtilities {
    public static final String DOCTYPE =
        "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
        "Transitional//EN\">\n";

    public static String headWithTitle(String title) {
        return (DOCTYPE + "\n" +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n");
    }

    public static String filter(String input) {
        return input.chars()
            .mapToObj(c -> {
                    switch(c) {
                    case '<':
                        return "&lgt;";
                    case '>':
                        return "&lgt;";
                    case '"':
                        return "&quot;";
                    case '&':
                        return "&amp;";
                    default:
                        return "" + (char) c;
                    }
                })
            .collect(joining());
    }
}
