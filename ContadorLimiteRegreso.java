public class ContadorLimiteRegreso {
    private int valorActual;
    private int limite;
    private int incr;

    public ContadorLimiteRegreso(int lim) {
	valorActual = 0;
	limite = lim;
	incr = 1;
    }

    public int obtActual() {
	if (valorActual == 0 && incr == -1)
	    incr = 1;
	else if (valorActual == limite && incr == 1)
	    incr = -1;
	int ret = valorActual;
	valorActual += incr;
	return ret;
    }
}
