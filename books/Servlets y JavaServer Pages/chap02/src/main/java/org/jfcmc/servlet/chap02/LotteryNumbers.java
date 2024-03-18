package org.jfcmc.servlet.chap02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LotteryNumbers extends HttpServlet {
    private long modTime;
    private int[] numbers = new int[10];

    public void init(ServletConfig config)
	throws ServletException {

	modTime = System.currentTimeMillis() / 1000 * 1000;
	for (int i = 0; i < numbers.length; i++) {
	    numbers[i] = randomNumber();
	}
    }

    public void doGet(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String title = "Your Lottery Numbers";
	out.println(ServletUtilities.headWithTitle(title) +
		    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
		    "<H1 ALIGN=CENTER>" + title + "</H1>" +
		    "<B>After a deep research of movement of starts " +
		    "We have choosen your numbers to win the lottery.</B>"+
		    "<OL>");

	for (int i = 0; i < numbers.length; i++) {
	    out.println("   <LI>" + numbers[i] + "<BR>");
	}

	out.println("</OL>" +
		    "</BODY></HTML>");
    }

    public long getyLastModified(HttpServletRequest request) {
	return modTime;
    }

    public int randomNumber() {
	return ((int) (Math.random() * 100));
    }
}
