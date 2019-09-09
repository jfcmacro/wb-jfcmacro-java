import java.util.Scanner;

public class Scores {

    public static void main(String[] args) {
	int[][] scores = new int[4][3];

	Scanner scan = new Scanner(System.in);

	for (int i = 0; i < scores.length; i++) {
	    for (int j = 0; j < scores[i].length; j++) {
		System.out.print("Student: " + (i + 1) + ", exam "
				 + (j + 1) + ": ");
		scores[i][j] = scan.nextInt();
	    }
	    System.out.println();
	}

    }

}
