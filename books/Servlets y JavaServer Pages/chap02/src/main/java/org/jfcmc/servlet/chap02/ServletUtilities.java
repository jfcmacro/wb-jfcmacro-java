package org.jfcmc.servlet.chap02;

public class ServletUtilities {
    public static final String DOCTYPE =
	"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	"Transitional//EN\">\n";
    
    public static String headWithTitle(String title) {
	return (DOCTYPE + "\n" +
		"<HTML>\n" +
		"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n");
    }
}
