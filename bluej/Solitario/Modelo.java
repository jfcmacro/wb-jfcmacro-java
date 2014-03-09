
import co.edu.eafit.dis.st051.cartas.SolitarioMVC.*;

class Modelo implements ModelWrapper {
	
	static final String valor[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	static int actual = 0;
	
	public static void main(String[] args) {
		SolitareFrame world = new SolitareFrame(new Modelo());
	}

	public boolean mover(int origen, int nroCarta, int destino) {
		return true;		
	}

	public ImagenCarta siguienteCarta(int origen) {
		try {
			ImagenCarta iC = new ImagenCarta(valor[actual],ImagenCarta.SPADE);
			actual = (actual + 1)% valor.length;
			return iC;
		}
		catch (ImagenCartaException e) {
			System.out.println("EXCEPCION AL CREAR CARTA: " + actual);
			return null;
		}
	}	
}
