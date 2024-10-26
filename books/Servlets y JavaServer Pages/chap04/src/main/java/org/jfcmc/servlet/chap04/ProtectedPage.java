package org.jfcmc.servlet.chap04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Properties;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.util.Base64.getDecoder;
import static java.util.Base64.Decoder;

public class ProtectedPage extends HttpServlet {
    private Properties passwords;
    private String passwordFile;

    public void init(ServletConfig config)
        throws ServletException   {
        super.init(config);

        try {
            passwordFile = config.getInitParameter("passwordFile");
            passwords = new Properties();
            passwords.load(new FileInputStream(passwordFile));
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printer = response.getWriter();
        String authorization = request.getHeader("Authorization");

        if (Objects.isNull(authorization)) {
            askPassword(response);
        }
        else {
            String userInfo = authorization.substring(6).trim();
            Decoder decoder = getDecoder();
            String nameAndPassword = new String(decoder.decode(userInfo));
            int index = nameAndPassword.indexOf(":");
            String user = nameAndPassword.substring(0, index);
            String password = nameAndPassword.substring(index + 1);
            String truePassword = passwords.getProperty(user);
            if ((Objects.nonNull(truePassword)) &&
                (truePassword.equals(password))) {
                String title = "Welcome to protected page";
                printer.println(ServletUtilities.headWithTitle(title) +
                                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                                "Congratulations! You have accessed to a\n" +
                                "document to proper of a company.\n" +
                                "Crush or eat all printed copies\n" +
                                "before you're going to the bed this night.\n" +
                                "</BODY></HTML>");
            } else {
                askPassword(response);
            }
        }
    }

    private void askPassword(HttpServletResponse response) {
        response.setStatus(response.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate",
                           "BASIC realm=\"priviliged-few\"");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}
