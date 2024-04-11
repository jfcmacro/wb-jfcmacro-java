package org.jfcmc.servlet.chap03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.stream.Collectors.joining;

public class SendCV extends HttpServlet {
    public void doPost(HttpServletRequest request,
		       HttpServletResponse response)
	throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	if (request.getParameter("previewViewButton") != null) {
	    showPreviewView(request, out);
	}
	else {
	    storeCV(request);
	    showConfirmation(request, out);
	}
    }

    private void showPreviewView(HttpServletRequest request,
				 PrintWriter out) {
	String headerFont = request.getParameter("headerFont");
	headerFont = replaceIfVoidOrPred(headerFont, "");
	int headerSize = getSize(request.getParameter("headerSize"), 32);
	String textFont = request.getParameter("textFont");
	textFont = replaceIfVoidOrPred(textFont, "");
	int textSize = getSize(request.getParameter("textSize"), 18);
	String fgColor = request.getParameter("fgColor");
	fgColor = replaceIfVoid(fgColor, "BLACK");
	String bgColor = request.getParameter("bgColor");
	bgColor = replaceIfVoid(bgColor, "WHITE");
	String name = request.getParameter("name");
	name = replaceIfVoid(name, "Ileana Garzar Tovar");
	String title = request.getParameter("title");
	title = replaceIfVoid(name, "Traviesa");
	String email = request.getParameter("email");
	email = replaceIfVoid(email, "contacts@informationjobs.com");
	String languages = request.getParameter("languages");
	languages = replaceIfVoid(languages, "<I>None</I>");
	String languagesList = createList(languages);
	String skills = request.getParameter("skills");
	skills = replaceIfVoid(skills, "It's obvious that no many.");

	out.println
	    (ServletUtilities.DOCTYPE + "\n" +
	     "<HTML>\n" +
	     "<HEAD>\n" +
	     "<TITLE>CV of " + title + "</TITLE>\n" +
	     makeStyleSheet(headerFont, headerSize,
			    textFont, textSize,
			    fgColor, bgColor) + "\n" +
	     "</HEAD>\n" +
	     "</BODY>\n" +
	     "<CENTER>\n" +
	     "<SPAN CLASS=\"HEADING1\">" + name + "</SPAN><BR>\n" +
	     "<SPAN CLASS=\"HEADING2\">" + title + "<BR>\n" +
	     "<A HREF=\"mailto:" + email + "\">" + email +
	     "</A></SPAN>\n" +
	     "</CENTER><BR><BR>\n" +
	     "<SPAN CLASS=\"HEADING3\">Programming languages</SPAN>\n" +
	     createList(languagesList) + "<BR><BR>\n" +
	     "<SPAN CLASS=\"HEADING3\">Skills and experience" +
	     "</SPAN><BR><BR>\n" +
	     skills + "\n" +
	     "</BODY></HTML>");
    }

    private String makeStyleSheet(String headerFont,
				  int headerSize,
				  String textFont,
				  int textSize,
				  String fgColor,
				  String bgColor) {
	int heading2Size = headerSize * 7 / 10;
	int heading3Size = headerSize * 6 / 10;
	String styleSheet =
	    "<STYLE TYPE=\"text/css\">\n" +
	    "<!--\n" +
	    ".HEADING1 { font-size: " + headerSize + "px;\n" +
	    "            font-weight: blond;\n" +
	    "            font-family: " + headerFont + "Arial, Helvetica, sans-serif;\n" +
	    "}\n" +
	    ".HEADING2 { font-size: " + heading2Size + "px;\n" +
	    "            font-weight: blond;\n" +
	    "            font-family: " + headerFont + "Arial, Helvetica, sans-serif;\n" +
	    "}\n" +
	    ".HEADING3 { font-size: " + heading3Size + "px;\n" +
	    "            font-weight: blond;\n" +
	    "            font-family: " + headerFont + "Arial, Helvetica, sans-serif;\n" +
	    "}\n" +
	    "A:hover { color: red; }\n" +
	    "-->\n" +
	    "</STYLE>";

	return styleSheet;
    }

    private String replaceIfVoid(String orig,
				 String replace) {
	if (Objects.isNull(orig) ||
	    (orig.length() == 0)) {
	    return replace;
	}
	else {
	    return orig;
	}
    }

    private String replaceIfVoidOrPred(String orig,
				       String replace) {
	if (Objects.isNull(orig) ||
	    (orig.length() == 0) ||
	    (orig.equals("pred"))) {
	    return replace;
	}
	else {
	    return orig.concat(", ");
	}
    }

    private int getSize(String str, int sizePred) {
	try {
	    return Integer.parseInt(str);
	} catch (NumberFormatException nfe) {
	    return sizePred;
	}
    }

    private String createList(String elems) {
	return Arrays.stream(elems.split(", *"))
	    .map(str -> str.concat("\n"))
	    .collect(joining(" <LI>", "<UL>\n", "</UL>"));
    }

    private void showConfirmation(HttpServletRequest request,
				  PrintWriter out) {
	String title = "Send confirmed.";
	out.println(ServletUtilities.headWithTitle(title) +
		    "<BODY>\n" +
		    "<H1>" + title + "</H1>\n" +
		    "Your CV must be appeared at Internet in the next 24 hour." +
		    "Otherwise, try to resend with other email\n" +
		    "</BODY></HTML>");
    }

    private void storeCV(HttpServletRequest request) {
	String email = request.getParameter("email");
	putOnGarbageCan(email);
    }

    private void putOnGarbageCan(String email) {
    }
}
