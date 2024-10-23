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

import static java.util.Base64.Decoder;

public class ProtectedPage extends HttpServlet {
    private Properties passwords;
    private String passwordFile;

    public void init(ServletConfig config)
	throws ServletException   {
	super.init(config);

	try {
	    passwordFile = config.getInitParameter("passwordFile");
	    password = new Properties();
	    password.load(new FileInputStream(passwordFile));
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
	    Decoder decoder = new Decoder();
	    BASE64Decoder decoder = new BASE64Decoder();
	    String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
	    int index = nameAndPassword.indexOf(":");
	    String user = nameAndPassword.substring(0, index);
	    String password = nameAndPassword.substring(index + 1);
	    String truePassword = password.getProperty(user);
	    if ((Objects.nonNull(truePassword)) &&
		(truePassword.equals(password))) {
		String title = "Welcome to protected page";
		out.println(ServletUtilities.headWithTitle(title) +
			    "<BODY BGCOLOR=\"#f
	    }
    }
}
