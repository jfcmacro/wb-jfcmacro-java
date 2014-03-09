package examples.ch4;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.SWT;

public class RowLayoutHorizontal {
  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new RowLayout(SWT.HORIZONTAL));
    RowLayout rowL =  (RowLayout) shell.getLayout();
    // rowL.wrap = false;
    rowL.justify = true;
    rowL.marginBottom = 100;
    
    Button b1 = new Button(shell, SWT.PUSH);
    b1.setText("one");
    b1.setLayoutData(new RowData(100,50));
    b1 =  new Button(shell, SWT.PUSH);
    b1.setText("two");
    b1.setLayoutData(new RowData(100,50));
    b1 = new Button(shell, SWT.PUSH);
    b1.setText("three");
    b1.setLayoutData(new RowData(100,50));
    b1 = new Button(shell, SWT.PUSH);
    b1.setText("four");
    b1.setLayoutData(new RowData(100,50));
    b1 = new Button(shell, SWT.PUSH);
    b1.setText("five");
    b1.setLayoutData(new RowData(100,50));
    b1 = new Button(shell, SWT.PUSH);
    b1.setText("six");
    b1.setLayoutData(new RowData(100,50));
    b1 = new Button(shell, SWT.PUSH);
    b1.setText("seven");
    b1.setLayoutData(new RowData(100,50));
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
