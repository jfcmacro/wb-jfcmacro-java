package org.jfcmc.servlet.chap05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="show-cgi-variables", urlPatterns="/chap05/CGIVariables")
public class ShowGCIVariables extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String[][] variables =
            { { "AUTH_TYPE", request.getAuthType() },
              { "CONTENT_LENGTH", String.valueOf(request.getContentLength()) },
              { "CONTENT_TYPE", request.getContentType() },
              { "DOCUMENT_ROOT", getServletContext().getRealPath("/") },
              { "PATH_INFO", request.getPathInfo() },
              { "QUERY_STRING", request.getQueryString() },
              { "REMOTE_ADDR", request.getRemoteAddr() },
              { "REMOTE_HOST", request.getRemoteHost() },
              { "REMOTE_USER", request.getRemoteUser() },
              { "REQUEST_METHOD", request.getMethod() },
              { "SCRIPT_NAME", request.getServletPath() },
              { "SERVER_NAME", request.getServerName() },
              { "SERVER_PORT", String.valueOf(request.getServerPort()) },
              { "SERVER_PROTOCOL", request.getProtocol() },
              { "SERVER_SOFTWARE", getServletContext().getServerInfo() }
            };

	String title = "Servlet Example: Showing CGI Variables";

	out.println(ServletUtilities.headWithTitle(title) +
		    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		    "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
		    "<TABLE BORDER=1 ALIGN=CENTER>\n" +
		    "<TR BGCOLOR=\"#FFAD00\">\n" +
		    "<TH> CGI Variable <TH> Value");

	Arrays.asList(variables)
	    .stream()
	    .forEach(a -> {
		    String varValue = a[1];
		    if (varValue == null) {
			varValue = "<I>Without Specified</I>";
		    }
		    out.printf("<TR><TD>%s<TD>%s%n", a[0], varValue);
		});
	out.println("</TABLE></BODY></HTML>");
    }

    public void doPost(HttpServletRequest request,
		       HttpServletResponse response)
        throws ServletException, IOException {
	doGet(request, response);
    }
}
