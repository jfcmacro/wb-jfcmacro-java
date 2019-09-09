public class UsarContadorLimiteRegreso {
    public static void main(String[] args) {
	ContadorLimiteRegreso clr = new ContadorLimiteRegreso(3);

	for (int i = 0; i < 30; i++) {
	    System.out.println(clr.obtActual());
	}
    }
}
