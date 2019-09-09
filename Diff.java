import java.util.Scanner;

public class Diff {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	boolean primero = true;
	float num, ant;
	num = ant = 0.0f;
	while (scan.hasNextFloat()) {
	    num = scan.nextFloat();
	    if (primero) {
		ant = num;
		primero = false;
	    }
	    else {
		float diff = num - ant;
		System.out.println("Diff: " + diff);
		ant = num;
	    }
	}
    }
}
