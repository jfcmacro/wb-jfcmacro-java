import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingApplication {

    private static int retval;

    public static void main(String []args) {

	try {
	    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	} catch (Exception e) {
	}
	JFrame frame = new JFrame("Swing Application");
	retval = 1;

	frame.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
               System.exit(retval);
            }
	    });

	frame.pack();
	frame.setVisible(true);
    }
}
