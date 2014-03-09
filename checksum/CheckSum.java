
public class CheckSum 
{
    public static byte[] checksum(byte[] mensaje, int length) {

	int suma = 0;
	int i = 0;

	while (i < length) {
	    suma += mensaje[i];
	    i++;
	}

	byte[] result = new byte[2];

	suma %= 65536;

	result[0] = (byte) (suma & 0xFF);
	result[1] = (byte) ((suma >> 8) & 0xFF);
	return result;
    }

    public static void main(String args[]) {

	if (args.length == 0) {
	    System.err.println("Uso: java CheckSum <strings>");
	    System.exit(1);
	}
	 
	byte[] mensaje = args[0].getBytes();
	
	byte[] result = checksum(mensaje, mensaje.length);
	
	System.out.println("byte[0]: " + result[0] +
			   "byte[1]: " + result[1]);
    }
}
