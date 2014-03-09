package examples.ch4;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;

public class GridLayout2x2 {
  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    GridLayout layout = new GridLayout();
    layout.numColumns = 3;
    layout.makeColumnsEqualWidth = true;
    shell.setLayout(layout);

    GridData data = new GridData();
    Button one = new Button(shell, SWT.PUSH);
    one.setText("one");
    one.setLayoutData(data);

    data = new GridData(GridData.FILL_BOTH);
    Button two = new Button(shell, SWT.PUSH);
    two.setText("two");
    two.setLayoutData(data);

    data = new GridData();
    Button three = new Button(shell, SWT.PUSH);
    three.setText("three");
    three.setLayoutData(data);

    data = new GridData(GridData.FILL_VERTICAL);
    Button four = new Button(shell, SWT.PUSH);
    four.setText("four");
    four.setLayoutData(data);

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
