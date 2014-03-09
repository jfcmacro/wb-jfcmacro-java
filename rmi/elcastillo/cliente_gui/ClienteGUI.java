package elcastillo.cliente_gui;

import java.rmi.Naming;
import elcastillo.notaria.Sellador;
import elcastillo.registro.Registro;
import elcastillo.security.LaxSecurityManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClienteGUI {

    JTextField registroTextField, selladorTextField;
    
    public ClienteGUI(Registro rServer, Sellador sServer) {

	final Registro r = rServer;
	final Sellador s = sServer;

	final JFrame mainFrame = new JFrame("Cliente GUI");

	mainFrame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
		    System.exit(0);
		}
	    });

	final JPanel mainPane = new JPanel();
	final JPanel pane1 = new JPanel();
	final JPanel pane2 = new JPanel();
	final JPanel pane3 = new JPanel();

	final JButton registroButton = new JButton("Registrar");
	final JButton selladorButton = new JButton("Sellador");

	final JTextField registroTextField = new JTextField(10);
	final JTextField selladorTextField = new JTextField(10);

	registroButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		    try {
			int value = r.registrar();
			registroButton.setText(""+value);
		    } catch (Exception e) {
			System.err.println("Error al conectar: " + e);
			System.exit(1);
		    }
		}
	    });

	selladorButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		    try {
			registroButton.setText(s.sellador());
		    } catch (Exception e) {
			System.err.println("Error al conectar: " + e);
			System.exit(1);
		    }
		}
	    });
	
	registroTextField.setEditable(false);
	selladorTextField.setEditable(false);

	mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.Y_AXIS));
       
	pane1.setLayout(new FlowLayout());

	pane1.add(new JLabel("Registro: "));
	pane1.add(registroTextField);
	pane1.add(registroButton);

	pane2.setLayout(new FlowLayout());
	pane2.add(new JLabel("Sellador: "));
	pane2.add(selladorTextField);
	pane2.add(selladorButton);

	mainPane.add(pane1);
	mainPane.add(pane2);
	mainPane.add(pane3);

	mainFrame.setContentPane(mainPane);
	mainFrame.pack();
	mainFrame.setVisible(true);  
    }

    public static void main(String []args) {

	if (args.length != 2) {
	    System.err.println("Usage: ClienteGUI <rmiregistro> <rmisellador>");
	    System.exit(1);
	}

	if (System.getSecurityManager() == null) {
	    System.setSecurityManager(new LaxSecurityManager());
	}
       

	try {

	    Sellador s = (Sellador) Naming.lookup("rmi://dis7.eafit.edu.co/SelladorOficial");
	    Registro r = (Registro) Naming.lookup("rmi://dis7.eafit.edu.co/RegistroOficial");

	    new ClienteGUI(r, s);

	} catch (Exception e) {
	    System.err.println("Exception: " + e);
	}
    }
}
