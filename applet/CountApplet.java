// CountApplet.java

import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.*;
import java.rmi.*;

public class CountApplet extends JApplet {

    private TextArea resultArea 
	= new TextArea("", 20, 72, TextArea.SCROLLBARS_BOTH);
    private Button connect = new Button("Connectar");
    private String server;

    public void init() {

	this.getContentPane().setLayout(new BorderLayout());
	
	Panel north = new Panel();
	north.add(new Label("Pulse el boton para conectarse"));
	north.add(connect);
	this.getContentPane().add(resultArea, BorderLayout.CENTER);
	this.getContentPane().add(north, BorderLayout.NORTH);
	Count c = new Count();
	connect.addActionListener(c);
	resultArea.setEditable(false);
	
	server = "rmi://" + this.getCodeBase().getHost() + "/myCountRMI";
    }

    class Count implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    
	    try {
		
		CountRMI myCount = (CountRMI) Naming.lookup(server);
		resultArea.append("Setting Sum to 0\n");
		myCount.sum(0);
		
		// Calculando el tiempo de inicio
		long startTime = System.currentTimeMillis();
		// Incrementa 1000 veces
		resultArea.append("Incrementando\n");
		
		for (int i = 0; i < 1000; i++) {
		    myCount.increment();
		}

		long stopTime = System.currentTimeMillis();
		resultArea.append("Avg Ping = " + ((stopTime - startTime)/1000f)
				  + " msecs\n");
		resultArea.append("Sum = " + myCount.sum() + "\n");
	    } catch (Exception ee) {
		resultArea.append("Exception: " + ee + "\n");
	    }
	}
    }
}
	    
		    
