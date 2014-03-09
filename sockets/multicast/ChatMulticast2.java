import java.net.*;
import java.io.*;

public class ChatMulticast2 {

    static class ChatMulticast2Helper implements Runnable {

	public ChatMulticast2Helper(MulticastSocket ms, 
				    InetAddress group,
				    int port) {
	    this.ms = ms;
	    this.group = group;
	    this.port = port;
	}

	MulticastSocket ms;
	InetAddress group;
	int port;
	
	public void run() {
	    
	    try {
		BufferedReader userInput = 
		    new BufferedReader(new InputStreamReader(System.in));

		while (true) {
		    
		    String theLine = userInput.readLine();
		    
		    byte[] data = theLine.getBytes();

		    DatagramPacket output =
			new DatagramPacket(data, data.length, group, port);
		    
		    ms.setTimeToLive(1);
		    ms.send(output);
		}
	    } catch (Exception e) {
		System.err.println("No pudo terminar");
		System.exit(1);
	    }
	}
    }

    public static void main(String[] args) {

	InetAddress group = null;
	int port = 0;

	byte data[] = new byte[8192];

	try {
	    group = InetAddress.getByName(args[0]);
	    port = Integer.parseInt(args[1]);
	}
	catch (Exception e) {
	    System.err.println("Usage: java ChatMulticast2 maddr port");
	    System.exit(1);
	}

	MulticastSocket ms = null;

	try {

	    ms = new MulticastSocket(port);
	    ms.setReuseAddress(true);
	    ms.joinGroup(group);

	    new Thread(new ChatMulticast2Helper(ms, group, port)).start();

	    DatagramPacket dp = new DatagramPacket(data, data.length);

	    while (true) {

		ms.receive(dp);
		String s = new String(dp.getData());
		System.out.println(s);
	    }

	}
	catch (Exception e) {
	    System.err.println(e);
	    System.exit(1);
	}
	finally {
	    if (ms != null) {
		try {
		    ms.leaveGroup(group);
		    ms.close();
		}
		catch (IOException ioe) { }
	    }
	}
    }
}
