import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

public class Main3 {
    private static void imprimir(int i, double d) {
        try {
            System.out.printf("%d %f%n", i, d);
        }
        catch (Exception e) {
            // ...
        }
        finally {
        }
    }

    // Operadores logicos: && || ! boolean    true && true  true && false
    // Operadores a nivel de bits: & | ~ short byte int long
    // byte b1 = 10;  // 00001010
    // byte b2 = 0xF; // 00001111
    // byte b3 = b1 & b2; // 00001010
    // byte b4 = b1 | b2; // 00001111
    // byte b5 = ~b1 // 11110101

    public static void main(String...args) {

        int j = 1;
        try (Scanner scan = new Scanner(System.in);)
            {
            int i = scan.nextInt();
            double d = scan.nextDouble();

            imprimir(i, d);
        }
        catch (InputMismatchException | IllegalStateException e) {
            System.out.println("Aparecio una excepción: " + e);
        }
        finally {
            j++;
        }

        System.out.printf("j: %d%n", j);
    }
}
