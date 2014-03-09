import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingApplication {

    public static void main(String []args) {

	JFrame frame = new JFrame("Swing Application");
	
	frame.addWindowListener(new WindowAdapter() {
	    public void windowClosing() {
               System.exit(1);
            }
	    });
				
	frame.pack();
	frame.setVisible(true);
    }
}
