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

public class ServletIncorrectCoding extends HttpServlet {
    private String snippetCode =
	"if (a<b) {\n" +
	"   doThis();\n" +
	"} else {\n" +
	"   doThat();\n" +
	"}\n";

    public String getSnippetCode() {
	return snippetCode;
    }

    public void doGet(HttpServletRequest request,
		       HttpServletResponse response)
	throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String title = "The if instruction in Java";

	out.println(ServletUtilities.headWithTitle(title) +
		    "<BODY>\n" + 
		    "<H1>" + title + "</H1>\n" +
		    "<PRE>\n" +
		    getSnippetCode() +
		    "</PRE>\n" +
		    "</BODY></HTML>");
    }
}
