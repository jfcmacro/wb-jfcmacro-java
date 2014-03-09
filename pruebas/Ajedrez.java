// Ajedrez
import java.math.BigInteger;

public class Ajedrez {

    

    public static void main(String args[]) {
	BigInteger sum = BigInteger.ZERO;
	BigInteger dos = new BigInteger("2");
	BigInteger j   = BigInteger.ONE;

	System.out.println("Sum: " + sum + " j: " + j);

	for (int i = 0; i < 64; i++, j = j.multiply(dos)) {
	    sum = sum.add(j);
	}

	System.out.println("Sum: " + sum + " ultimo: " + j);

    }

}
