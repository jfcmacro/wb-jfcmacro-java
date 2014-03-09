import java.net.*;
import java.io.*;

public class Broadcast {

    DatagramSocket ds;
    
    private class ListenBroadcast implements Runnable {

	DatagramSocket ds;

	ListenBroadcast(DatagramSocket ds) {
	    
	    this.ds = ds;
	    (new Thread(this)).start();
	}
    
	public void run() {
	    
	    byte[] buffer = new byte[256];
	    
	    DatagramPacket dp = 
		new DatagramPacket(buffer, buffer.lenght);
	    
	    while (true) {

		try {

		    int nBytesReceived = ds.receive(dp);

		    String incomingData = new String(buffer, nBytesReceived);

		    System.out.println(incomingData);
		} 
		catch (IOException ioe) {
		    
		    System.err.println("Error: " + ioe);
		    System.exit(1);
		}
		catch (InterruptedException ie) {
		    
		    System.err.println("Someone interrupted the thread: " + ie);
		    System.exit(1);
		}
	    }
	    
	}
    }

    public Broadcast(String broadcastAddr, int listenPort, int outPort) {

	
    }

    public static void main(String args[]) {
    }
}
