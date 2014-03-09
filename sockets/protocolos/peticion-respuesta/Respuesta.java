import java.io.*;
import java.net.*;

public class Respuesta
{
    int puerto;
    DatagramSocket ds = null;
    int cont;

    public Respuesta(int puerto, int cont) 
	throws SocketException
    {
	ds = new DatagramSocket(puerto);
	this.cont = cont;
    }

    public void ejecutar() {
	InetAddress clienteAddress;
	int clientePuerto;
	byte buffer[] = new byte[5];
	DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

	while (true) {
	    
	    try {
		ds.receive(dp);

		if (buffer[0] == 'p') {
		    buffer[0] = 'r';
		    
		    buffer[1] = (byte)((cont >> 24) & 0xFF);
		    buffer[2] = (byte)((cont >> 16) & 0xFF);
		    buffer[3] = (byte)((cont >> 8)  & 0xFF);
		    buffer[4] = (byte)((cont >> 0)  & 0xFF);

		    dp.setData(buffer);
		    ds.send(dp);
		    cont++;
		}
	    } catch (IOException ioe) {
		System.err.println("Respuesta terminada\n");
		System.exit(1);
	    }
	}
    }
}
