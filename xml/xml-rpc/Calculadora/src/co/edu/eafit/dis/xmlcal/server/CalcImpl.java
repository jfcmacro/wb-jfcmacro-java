package co.edu.eafit.dis.xmlcal.server;

public class CalcImpl implements Calculator {

    public int sumar(int valor1, int valor2) {

	System.out.println("Ejecutando: " + valor1 + " " + valor2);
	return valor1 + valor2;
    }

    public short prueba(short valor1, short valor2) {

	System.out.println("Ejecutando: " + valor1 + " " + valor2);
	return (short) (valor1 + valor2);
    }
}