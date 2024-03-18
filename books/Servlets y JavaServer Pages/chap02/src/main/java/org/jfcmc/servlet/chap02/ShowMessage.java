package org.jfcmc.servlet.chap02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowMessage extends HttpServlet {
    private String message;
    private String prevMessage = "Without Mesagges";
    private int times = 1;

    public void init(ServletConfig config)
	throws ServletException {
	super.init(config);
	message = config.getInitParameter("message");
	if (message == null) {
	    message = prevMessage;
	}
	try {
	    String strTimes = config.getInitParameter("times");
	    times = Integer.parseInt(strTimes);
	} catch (NumberFormatException nfe) {
	}
    }

    public void doGet(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String title = "Servlet ShowMessage";
	out.println(ServletUtilities.headWithTitle(title) +
		    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		    "<H1 ALIGN=CENTER>" + title + "</H1>");

	for (int i = 0; i < times; i++) {
	    out.println(message + "<BR>");
	}

	out.println("</BODY></HTML>");
    }
}
