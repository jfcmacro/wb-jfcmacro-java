package org.jfcmc.servlet.chap03;

public class ServletFilterCode extends ServletIncorrectCoding {
    public String getSnippetCode() {
	return ServletUtilities.filter(super.getSnippetCode());
    }
}
