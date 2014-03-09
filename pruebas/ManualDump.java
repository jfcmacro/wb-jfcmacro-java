import java.io.*;

public class ManualDump {
    public static void main(String args[]) 
	throws IOException {
	Throwable t = new Throwable();
	StringWriter sw = new StringWriter();
	PrintWriter pw = new PrintWriter(sw);
	t.printStackTrace(pw);
	String input = sw.getBuffer().toString();
	StringReader sr = new StringReader(input);
	BufferedReader br = new BufferedReader(sr);
	br.readLine(); // Exception name
	String line = br.readLine();
	int paren = line.indexOf('(');
	line = line.substring(0, paren);
	int period = line.lastIndexOf('.');
	line = line.substring(period+1);
            System.out.println("Method: " + line);
    }
}
