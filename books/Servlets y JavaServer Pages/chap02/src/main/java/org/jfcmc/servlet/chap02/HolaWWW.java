package org.jfcmc.servlet.chap02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaWWW extends HttpServlet {

    public void doGet(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException {

	PrintWriter out = response.getWriter();
	String docType =
	    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	    "Transitional//EN\">\n";


	out.println(docType +
		    "<HTML>\n" +
		    "<HEAD><TITLE>Hola WWW</TITLE></HEAD>\n" +
		    "<BODY>\n" +
		    "<H1>Hola WWW</H1>\n" +
		    "</BODY></HTML>");
    }
}
