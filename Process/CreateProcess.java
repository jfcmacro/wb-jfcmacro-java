import java.io.File;
import java.io.IOException;

public class CreateProcess {
    public static void main(String args[])
	throws IOException
    {
	ProcessBuilder pb = new ProcessBuilder("ls", "-l", "/");
	File output = new File("/tmp/salida");
	pb.redirectOutput(output);
	Process p = pb.start();
	System.exit(0);
    }
}
