import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.util.Formatter;
import static java.util.Locale.US;

public class ScannerReading {
    public static void main(String...args) throws IOException {
        Scanner scan = new Scanner(new BufferedReader(new FileReader(args[0])));
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, US);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner scan2 = new Scanner(new StringReader(line))
                .useDelimiter(",");
            String brand = scan2.next();
            String model = scan2.next();
            int cylinder = scan2.nextInt();
            int performance = scan2.nextInt();
            double accelaration = scan2.nextDouble();
            // System.out.printf("%10s %10s %5d ccm %3d kw %5.2f sec%n",
            //                   brand, model, cylinder,performance, accelaration);
            formatter.format("%10s %10s %5d ccm %3d kw %5.2f sec%n",
                             brand, model, cylinder,performance, accelaration);
        }
        System.out.print(sb.toString());
    }
}
