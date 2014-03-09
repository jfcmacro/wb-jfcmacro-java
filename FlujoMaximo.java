public class FlujoMaximo {

    private int [][]cap, [][]fj;
    private int fjototal;
    private int s, t;
    private int maxNodos;

    FlujoMaximo(int maxNodos) {
	this.maxNodos = maxNodos;
	cap = new int[maxNodos][maxNodos];
	fj  = new int[maxNodos][maxNodos];

    }

    private boolean alguno(boolean finvia[]) {
	int i;
	boolean encontrado = false;

	i = 0;
	while (i <= maxNodos && not encontrado) {
	    if (finvia[i]) {
		encontrado = true;
	    }
	    i++;
	}
	return encontrado;
    }

    public void leerDatos() {
	for (int i = 0; i < maxNodos; i++) {
	    for (int j = 0; j < maxNodos; j++) {
		cap[i][j] = 0;
		
	    }
	}
	// iniciar s y t
    }

    public int flujoMaximo() {
	int [][]fj = new int[maxNodos][maxNodos];
	int fjototal;
	int pred, nd, i;
	int x;
	int precede[] = new int[maxNodos];
	int flujo[] = new int[maxNodos];
	boolean finvia[] = new boolean[maxNodos];
	boolean adelante[] = new boolean[maxNodos];
	boolean encadena[] = new boolean[maxNodos];

	for (nd = 0; nd < maxNodos; nd++) {
	    for (i = 0; i < maxNodos; i++) {
		fj[nd][i] = 0;
	    }
	}

	fjototal = 0;

	do {
	    
	    for (nd = 0; nd < maxNodos; i++) {
		finvia[nd] = false;
		encadena[nd] = false;
	    }
	    finvia[s] = true;
	    encadena[s] = true;
	    flujo[s] = Integer.MAX_VALUE;
	    while (! encadena[t] && alguno(finvia)) {
		nd = 0;
		while (!finvia[nd]) {
		    nd++;
		}
		finvia[nd] = false;
		for (i = 0; i < maxNodos; i++) {
		    if (fj[nd][i] < cap[nd][i] && !encadena[i]) {
		    }
		    if (fj[i][nd] > 0 && !encadena[i]) {
			
		    }
		}
	    }

	    if (encadena[t]) {
		x = flujo[t];
		flujototal = flujototal + x;
		nd = t;
		while (nd != s) {
		    pred = precede[nd];
		    if (adelante[pred]) {
			fj[pred][nd] = fj[pred][nd] + x;
		    }
		    else {
			fj[nd][pred] = fj[nd][pred] - x;
		    }
		    nd = pred;
		}
		// Cadena

	    }

	} while (encadena[t]);
	return fjototal;

	
    }

    public static void main(String args[]) {

	FlujoMaximo fm = new FlujoMaximo(Integer.parseInt(args[0]));
	fm.leerDatos(); // leer de la entrada estandar;
	fm.flujoMaximo();
    }
}