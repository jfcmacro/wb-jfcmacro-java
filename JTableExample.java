import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTableExample {

    static private Object[][] data;
    static private String[] colname;
    static {

	data = new Object[2][2];

	data[0][0] = "Numero";
	data[0][1] = 5;
	data[1][0] = "Valor";
	data[1][1] = 6;

	String[] tmp = {"Nombre", "Valor"};
	colname = tmp;
 // { { "Numero", new Integer(5) },
 // 		 { "Valor", new Integer(6) }};

 // 	colname = {"Nombre", "Valor"};

    }

    class MiTableModel extends AbstractTableModel {
	public int getColumnCount() {
	    return colname.length;
	}

	public int getRowCount() {
	    return data.length;
	}

	public String getColumnName(int col) {
	    return colname[col];
	}

	public Object getValueAt(int row, int col) {
	    return data[row][col];
	}

	public boolean isCellEditable(int row, int col) { return true; }

	public void setValueAt(Object value, int row, int col) {
	    data[row][col] = value;
	    fireTableCellUpdated(row, col);
	}
    }

    public JTableExample() {
    }

    public void init() {
	JFrame f = new JFrame("Tests");
	f.setSize(300,150);
	f.setLocation(200,200);

	f.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent ew) {
		    System.out.println("data: " + data[0][0]);
		    System.exit(0);
		}
	    });


	JPanel panel = new JPanel();

	final MiTableModel mtm = new MiTableModel();
	JTable jtab = new JTable(mtm);
	panel.add(jtab);

	Container cont = f.getContentPane();
	cont.setLayout(new GridLayout(1,1));
	cont.add(panel);

	Thread t = new Thread(new Runnable() {
		public void run() {
		    int i = 10;
		    while (true) {
			
			mtm.setValueAt(i, 0, 1);
			try {
			    Thread.sleep(2000);
			}
			catch (InterruptedException ie) {
			}
			i += 10;
		    }
		}
	    });

	t.start();
	f.setVisible(true);
    }

    public static void main(String args[]) {
	JTableExample jte = new JTableExample();
	jte.init();
    }
}
