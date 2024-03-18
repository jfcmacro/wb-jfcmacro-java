package org.jfcmc.servlet.chap02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaWWW3 extends HttpServlet {

    public void doGet(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException {

	PrintWriter out = response.getWriter();

	out.println(ServletUtilities.headWithTitle("Hola WWW3") +
		    "<BODY>\n" +
		    "<H1>Hola WWW</H1>\n" +
		    "</BODY></HTML>");
    }
}
