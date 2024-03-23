package org.jfcmc.servlet.chap03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowParameters extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Reading all request parameters";
        out.println(ServletUtilities.headWithTitle(title) +
                    "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                    "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                    "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                    "<TR BGCOLOR=\"#FFAD00\">\n" +
                    "<TH>Parameter's name<TH>Parameters Value(s)");

        Enumeration paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            out.print("<TR><TD>" + paramName + "\n<TD>");
            String[] values = request.getParameterValues(paramName);

            switch (values.length) {
            case 0:
                out.println("<I>No value</I>");
                break;
            case 1:
                out.println(values[0]);
                break;
            default:
                out.println("<UL>");
                Arrays.stream(values)
                    .map(str -> "<LI>".concat(str))
                    .forEach(out::println);
                out.println("</UL>");
                break;
            }

        }
        out.println("</TABLE>\n</BODY></HTML>");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}
