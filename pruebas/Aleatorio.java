import java.util.Random;

public class Aleatorio {

    public static void main(String []args) {

	Random r = new Random();

	for (int i = 0; i < 10; i++)
	    System.out.println("Aleatorio: " + r.nextInt(11));
    }
}
