
public class BreakLabeled {

    private float[][]Matrix;

    public boolean workOnFlag(float flag) {

	int y = 0, x = 0;
	boolean found = false;

	search:
	for (y = 0; y < Matrix.length; y++) {
	    for (x = 0; x < Matrix[y].length; x++) {
		if (Matrix[y][x] == flag) {
		    found = true;
		    break search;
		}
	    }
	}

	System.out.println("y: " + y + " x: " + x);

	if (!found)
	    return false;
	return true;
    }

    BreakLabeled() {
	Matrix = new float[10][10];
	
	for (int y = 0; y < Matrix.length; y++) {
	    for (int x = 0; x < Matrix[y].length; x++) {
		Matrix[y][x] = 0.0f;
	    }
	}

	Matrix[5][5] = 10.0f;
    }

    public static void main(String []args) {

	BreakLabeled bl = new BreakLabeled();

	if (bl.workOnFlag(10.0f))
	    System.out.println("Encontrado");
	else 
	    System.out.println("No encontrado");
    }
}
