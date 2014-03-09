
public class Parcial2 {

    public static void main(String []args) {
	Parcial2 p2 = new Parcial2();
	int vector[] = {1,0,1,0,2};
	System.out.println("Suma de comprobación1: " + p2.sumaDeComprobación(vector));
	int vector2[] = {1, 0, 1, 0, 3};
	System.out.println("Suma de comprobación2: " + p2.sumaDeComprobación(vector2));
	String s1 = "uno";
	System.out.println("s1: " + s1 + " medio: " + p2.mediosSimetricos(s1));
	String s2 = "alas";
	System.out.println("s2: " + s2 + " medio: " + p2.mediosSimetricos(s2));
	System.out.println("ajustaOjales(10,3)=" + p2.ajustaOjales(10,3));
	System.out.println("ajustaOjales(10,2)=" + p2.ajustaOjales(10,2));
	System.out.println("ajustaOjales(11,3)=" + p2.ajustaOjales(11,3));
	System.out.println("ajustaOjales(11,2)=" + p2.ajustaOjales(11,2));
	System.out.println("ajustaOjales(12,3)=" + p2.ajustaOjales(12,3));
	System.out.println("ajustaOjales(12,2)=" + p2.ajustaOjales(12,2));
	int lqbc[] = {1,2,4,5,1};
	System.out.println("loQueBienComienzaBienTermina({1,2,4,5,1})=" +
			   p2.loQueBienComienzaBienTermina(lqbc));
	lqbc = new int[] {} ;
	System.out.println("loQueBienComienzaBienTermina({})=" +
			   p2.loQueBienComienzaBienTermina(lqbc));
	lqbc = new int[] {5,6,7,9,5};
	System.out.println("loQueBienComienzaBienTermina({5,6,7,9,5})=" +
			   p2.loQueBienComienzaBienTermina(lqbc));
	lqbc = new int[] {1,4,7,9,5};
	System.out.println("loQueBienComienzaBienTermina({1,4,7,9,5})=" +
			   p2.loQueBienComienzaBienTermina(lqbc));
	System.out.println("comprimirAlPrincipio(\"  alPrincipio\")=" +
			   p2.comprimirAlPrincipio("  alPrincipio"));
	System.out.println("comprimirAlPrincipio(\"alPrincipio\")=" +
			   p2.comprimirAlPrincipio("  alPrincipio"));
	System.out.println("comprimirAlPrincipio(\" alPrincipio\")=" +
			   p2.comprimirAlPrincipio(" alPrincipio"));
	System.out.println("cifrador(\"cifrador\")="+ p2.cifrador("cifrador"));
	System.out.println("cifrador(\"holahola\")="+ p2.cifrador("holahola"));
	System.out.println("cifrador(\"unodos\")="+ p2.cifrador("unodos"));
	System.out.println("cifrador(\"trescuatro\")="+ p2.cifrador("trescuatro"));
	System.out.println("cifrador(\"holamundo\")="+ p2.cifrador("holamundo"));
	System.out.println("cifrador(\"amor a roma\")="+ p2.cifrador("amor a roma"));
	System.out.println("cifrador(\"muestra la muestra\")="+ p2.cifrador("muestra la muestra"));
	System.out.println("cifrador(\"trescuatro\")="+ p2.cifrador("trescuatro"));
	System.exit(0);
    }

    public Parcial2() {
    }

    public boolean sumaDeComprobación(int []arreglo) {
	int sum = 0;
	for (int i = 0; i < arreglo.length - 1; i++) {
	    sum = sum + arreglo[i];
	}
	if (sum == arreglo[arreglo.length - 1]) {
	    return true;
	}
	return false;
    }

    public String mediosSimetricos(String str) {
	String res = null;
	int medio = 0;

	if (str.length() % 2 == 0) {
	    medio = str.length() / 2;
	    res = str.substring(medio - 1, medio + 1);
	}
	else {
	    medio = str.length() / 2;
	    res = str.substring(medio, medio + 1);
	}
	return res;
    }

    public int análisisDePuentes(String str) {
	int refuerzos = 0;
	int contador = 0;
	for (int i = 0; i < str.length(); i++) {
	    if (str.charAt(i) == '=') contador++;
	    if (contador == 3) {
		refuerzos++;
		contador = 0;
	    }
	}
	return refuerzos;
    }

    public boolean ajustaOjales(int a, int b) {
	boolean ajusta = false;
	for (int i = 0; i < 4 && !ajusta; i++) {
	    if (a == b)
		ajusta = true;
	    a /= 2;
	}
	return ajusta;
    }

    public boolean balanceado(int []valores) {
	if (valores.length < 2 || ((valores.length % 2) != 0)) {
	    return false;
	}

	int sumaBaja = 0;
	int sumaAlta = 0;
	for (int i = 0; i < valores.length / 2; i++) {
	    sumaBaja += valores[i];
	}
	for (int i = valores.length / 2; i < valores.length; i++) {
	    sumaAlta += valores[i];
	}
	return sumaBaja == sumaAlta;
    }

    private boolean siPeroNo(boolean a, boolean b) {
	return (a && !b) || (!a && b);
    }

    public boolean noAmbosMayoresDeCuarenta(int a, int b) {
	return siPeroNo(a > 40, b > 40);
    }

    public boolean loQueBienComienzaBienTermina(int valores[]) {
	if (valores.length < 1) {
	    return false;
	}
	return valores[0] == valores[valores.length - 1];
    }

    public String comprimirAlPrincipio(String str) {
	int inicio = 0;
	while (inicio < str.length() && str.charAt(inicio) == ' ') inicio++;
	return str.substring(inicio);
    }

    public String cifrador(String str) {
	return str.substring(str.length() / 2, str.length()) + str.substring(0, str.length() / 2);
    }
}