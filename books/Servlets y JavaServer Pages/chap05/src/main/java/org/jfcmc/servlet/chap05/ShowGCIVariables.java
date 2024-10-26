package org.jfcmc.servlet.chap05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowGCIVariables extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        response.setContent("text/html");
        PrintWriter out = response.getWriter();
        String[][] variables =
            { { "AUTH_TYPE", request.getAuthType() },
              { "CONTENT_LENGTH", String.valueOf(request.getContentLength()) },
              { "CONTENT_TYPE", request.getContentType() },
              { "DOCUMENT_ROOT", getServletContext().getRealPath("/") },
              { "PATH_INFO", request.getPathInfo() },
              { "QUERY_STRING", request.getQueryString() },
              { "REMOTE_ADDR", request.getRemoteAddr() },
              { "", "" },
            };
    }
}
