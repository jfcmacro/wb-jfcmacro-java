
public class Factorial {

  public int factorial(int i) {
    if (i == 0) {
       return 1;
    }
    return i * factorial(i-1);
  }

  public static void main(String args[]) {
     Factorial f = new Factorial();

     System.out.println("Factorial de 5 es: " + f.factorial(5));
  }
}
