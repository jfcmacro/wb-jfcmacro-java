import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReadLineBufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int number = Integer.parseInt(line);
        System.out.println("Read Number: " + number); 
    }
}
