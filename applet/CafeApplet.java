// CafeApplet.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.*;
import java.util.*;

public class CafeApplet extends JApplet {

    private String server;
 
    public void init() {
	
	JPanel jpTipoCafe = new JPanel();
	final ButtonGroup bgTipoCafe = new ButtonGroup();
	JRadioButton radioButton;
	jpTipoCafe.add(radioButton = new JRadioButton("Moka"));
	radioButton.setActionCommand("Moka");
	bgTipoCafe.add(radioButton);
	jpTipoCafe.add(radioButton = new JRadioButton("Expreso"));
	radioButton.setActionCommand("Capuchino");
	bgTipoCafe.add(radioButton);
	jpTipoCafe.add(radioButton = new JRadioButton("Capuchino"));
	radioButton.setActionCommand("Capuchino");
	bgTipoCafe.add(radioButton);
	jpTipoCafe.add(radioButton = new JRadioButton("Cafe normal"));
	radioButton.setActionCommand("Cafe normal");
	bgTipoCafe.add(radioButton);

	final JPanel jpAdiciones = new JPanel();
	jpAdiciones.add(new JCheckBox("Crema"));
	jpAdiciones.add(new JCheckBox("Azucar"));
	jpAdiciones.add(new JCheckBox("Leche"));
	jpAdiciones.add(new JCheckBox("Canela"));

	JPanel jpSeleccion = new JPanel();
	
	String items[] = {"Descafeinado", "Semi-descafeinado", 
			  "Normal", "Alto tueste"};
	JList jlSeleccion = new JList(items);
	jpSeleccion.add(jlSeleccion);

	JPanel jpExec = new JPanel();
	JButton jbCancelar = new JButton("Borrar");
	jpExec.add(jbCancelar);
	JButton jbEnviar = new JButton("Enviar");
	jpExec.add(jbEnviar);
	Container content = this.getContentPane();
	content.setLayout(new GridLayout(4,1));
	content.add(jpTipoCafe);
	content.add(jpAdiciones);
	content.add(jpSeleccion);
	content.add(jpExec);
	
	server = "rmi://" + this.getCodeBase().getHost() + "/myCountRMI";

	jbEnviar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
		    String tipoCafe = bgTipoCafe.getSelection().getActionCommand();
		    Component[] components = jpAdiciones.getComponents();
		    java.util.List list = new Vector();
		    for (int i = 0; i < components.length; i++) {
			JCheckBox cb = (JCheckBox) components[i];
			if (cb.isSelected()) {
			    list.add(cb.getText());
			}
		    }
		    
		}
	    });
    }
}
	    
		    
