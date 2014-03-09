import org.eclipse.jface.viewers.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ListViewerExample {

    public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);
	shell.setText("List Viewer Example");
	shell.setBounds(100, 100, 200, 100);
	shell.setLayout(new FillLayout());
	System.out.println("Estoy listo");
	final ListViewer listViewer = new ListViewer(shell, SWT.SINGLE);
	System.out.println("Estoy pasado");
	listViewer.setLabelProvider(new PersonListLabelProvider());
	listViewer.setContentProvider(new ArrayContentProvider());
	listViewer.setInput(Person.example());
	listViewer.setSorter(new ViewerSorter() {
		public int compare(Viewer viewer, Object p1, Object p2) {
		    return ((Person) p1).lastName.compareToIgnoreCase(((Person) p2).lastName);
		}
	    });
	listViewer.addSelectionChangedListener(
	    new ISelectionChangedListener() {
		public void selectionChanged(
					     SelectionChangedEvent event) {
		    IStructuredSelection selection = 
			(IStructuredSelection) event.getSelection();
		    System.out.println("Selected: " +
				       selection.getFirstElement());
		}
	    });
	listViewer.addDoubleClickListener(
	    new IDoubleClickListener() {
		public void doubleClick(DoubleClickEvent event) {
		    IStructuredSelection selection = 
			(IStructuredSelection) event.getSelection();
		    System.out.println("Double Clicked: " +
				       selection.getFirstElement());
		}
	    });
	shell.open();
	while (!shell.isDisposed()) {
	    if (!display.readAndDispatch()) display.sleep();
	}
	display.dispose();
    }
}
						   
					       
				   
	
