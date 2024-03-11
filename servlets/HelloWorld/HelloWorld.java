import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// This is compiling using a Servlet 4.0.1
// javac -cp $SERVLET_DIR/javax.servlet-api-4.0.1.jar:. HelloWorld.java
// Running ?
public class HelloWorld extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
        throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 5.0 " +
                    "Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<BIG>Hello World</BIG>");
        out.println("</BODY></HTML>");

	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	out.println("<HTML>");
	out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
	out.println("<BODY>");
	out.println("<BIG>Hello World</BIG>");
	out.println("</BODY></HTML>");
        res.setContentType("text/html");
        PrintWriter out = res.getWrite;
        out.println("<HTML>");
        out.p
