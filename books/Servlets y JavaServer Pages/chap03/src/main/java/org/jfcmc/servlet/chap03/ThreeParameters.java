package org.jfcmc.servlet.chap03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreeParameters extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Reading three request parameters";
        out.println(ServletUtilities.headWithTitle(title) +
                    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                    "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                    "<UL>\n" +
                    "  <LI><B>param1</B>: "  +
                    request.getParameter("param1") + "\n" +
                    "  <LI><B>param2</B>: "  +
                    request.getParameter("param2") + "\n" +
                    "  <LI><B>param3</B>: "  +
                    request.getParameter("param3") + "\n" +
                    "</UL>\n" +
                    "</BODY></HTML>");
    }
}
