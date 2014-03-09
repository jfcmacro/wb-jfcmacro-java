import java.nio.*;
import java.nio.channels.SocketChannel;
import java.io.*;
import java.net.*;

public class PruebaSockets {

    public static void main(String []args) {

	try {

	    SocketChannel sc = SocketChannel.open();
	    sc.configureBlocking(true);

	    InetSocketAddress isa = new InetSocketAddress("proxy.eafit.edu.co",
							  8080);

	    StringBuffer sb = new StringBuffer();

	    sb.append("GET http://www.elcolombiano.com/hoy/npo001.htm HTTP/1.0\r\n")
		.append("Accept: text/html\r\n")
		.append("User-Agent: Unkown 0.0\r\n\r\n");

	    ByteBuffer bb = ByteBuffer.allocate(1024);
	    
	    System.out.println("Capacidad: " + bb.capacity() +
			       " Position: " + bb.position() +
			       " Limit: " + bb.limit());

	    bb.put(sb.toString().getBytes());

	    bb.flip();

	    System.out.println("Capacidad: " + bb.capacity() +
			       " Position: " + bb.position() +
			       " Limit: " + bb.limit());

	    System.out.println(" " + sb.length() + "longitud: " + sb.toString().getBytes().length);
	    sc.connect(isa);
	    
	    System.out.println("Escribio: " + sc.write(bb));

	    bb.flip();
	    bb.clear();

	    sb = new StringBuffer();

	    System.out.println("Listo para leer");

	    System.out.println("Capacidad: " + bb.capacity() +
			       " Position: " + bb.position() +
			       " Limit: " + bb.limit());

	    while (true) {
		
		sc.read(bb);

		System.out.println("Capacidad: " + bb.capacity() +
			       " Position: " + bb.position() +
			       " Limit: " + bb.limit());

		System.out.println("Ya llegaron algunos bytes");
		if (bb.position() == 0) 
		    break;
	       
		byte rec[] = new byte[bb.position()];

		bb.flip();

		System.out.println("Estoy listo para leerlos");

		bb.get(rec);

		System.out.println("se ha leído");
		
		sb = sb.append(new String(rec));
		bb.clear();
		System.out.println("Listo a leer de nuevo");
	    }
		
	    System.out.println("Llego: " );
	    System.out.print(sb.toString());
	    
	} catch (Exception e) {
	    System.out.println("Exception " + e);
	}
    }
}
