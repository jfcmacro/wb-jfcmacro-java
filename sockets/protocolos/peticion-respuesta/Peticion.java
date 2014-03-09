import java.net.*;
import java.io.*;

public class Peticion 
{
    String host = null;
    int puerto;
    final static int MAX = 5;

    public final class TimeoutErrorException 
	extends Exception {
	
	public TimeoutErrorException() {
	    super("Alcanzado maximo numero de repeticiones");
	}

	public TimeoutErrorException(String reason) {
	    super(reason);
	}
    }

    public Peticion(String host, int puerto) {
	this.host = host;
	this.puerto = puerto;
    }

    public int obtenerConsecutivo()
	throws SocketException,
	       UnknownHostException,
	       IOException,
	       TimeoutErrorException
    {
	int rep = 0;
	int valRet = 0;

	DatagramSocket ds = null;
	DatagramPacket dps = null;
	DatagramPacket dpr = null;
	byte dataSend[] = new byte[1];
	byte dataReceive[] = new byte[32];
	boolean recv = false;

	dataSend[0] = (byte) 'p';

	do {
	    
		ds = new DatagramSocket();
		dps = new DatagramPacket(dataSend, dataSend.length, 
					 InetAddress.getByName(host), puerto);
		
		ds.send(dps);
		
		ds.setSoTimeout(1000);
		
		dpr = new DatagramPacket(dataReceive, dataReceive.length);
				
		try {
		    ds.receive(dpr);
		    recv = true;

		    if (dataReceive[0] == 'r') {
			valRet = ((dataReceive[1] & 0xFF)   << 24) +
			    ((dataReceive[2] & 0xFF) << 16) +
			    ((dataReceive[3] & 0xFF) << 8) +
			    ((dataReceive[4] & 0xFF) << 0);
		    }
		    else {
			rep++;
		    }
		}
		catch (SocketTimeoutException ste) {
		    rep++;
		}
		catch (IOException ioe) {
		    rep ++;
		}
		
	} while (rep <=  MAX && !recv);

	if (rep > MAX)
	    throw new TimeoutErrorException();

	return valRet;
    }

}
