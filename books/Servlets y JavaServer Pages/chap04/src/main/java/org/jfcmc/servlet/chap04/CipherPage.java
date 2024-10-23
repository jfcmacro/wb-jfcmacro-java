package org.jfcmc.servlet.chap04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CipherPage extends HttpServlet {
    public void doGet(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException {
	response.setContentType("text/html");

	PrintWriter out = null;

	String title = null;

	String cipher = request.getHeader("Accept-Encoding");
	String cipherIndicator = request.getParameter("cipher");

	if (!Objects.isNull(cipher) &&
	    (cipher.indexOf("gzip") != -1) &&
	    !"no".equals(cipherIndicator)) {
	    title = "Ciphered Page with GZip";
	    out = new PrintWriter(new GZIPOutputStream(response.getOutputStream()), false);
	    response.setHeader("Content-Encoding", "gzip");
	}
	else {
	    title = "Page without cipher";
	    out = response.getWriter();
	}

	out.println(ServletUtilities.headWithTitle(title) +
		    "<BODY BGCOLOR=\"#FDF5E5\">\n" +
		    "<H1 ALIGN=CENTER>" + title + "</H1>\n");
	String line = "Bla, bla, bla, bla. " +
	    "More bla, bla, bla, bla, bla, bla, bla.";
	for (int i = 0; i < 1000; i++) {
	    out.println(line);
	}

	out.println("</BODY></HTML>");
	out.close();
    }
}
