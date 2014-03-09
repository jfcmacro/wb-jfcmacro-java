import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.print.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.jnlp.*;

public class PicoDraw extends JFrame
{
  // Application directory containing images
  static private final String backgroundDirectory = "backgrounds";

  // Application file containing list of background images
  static private final String backgroundList = "backgrounds.txt";

  // Local default directory for saving files
  static private final String savefileDirectory = "c:\\";

  // URL for web page showing instructions.  Change
  // this to point to the instructions file on your server
  static private final String instructionsURL =
    "http://192.168.0.1/jaws/PicoDraw/instructions.html";

  // Drawing field
  private DrawCanvas drawCanvas;

  // The last file we saved to
  private String lastFilename;

  // The last directory we saved to
  private File choosingDirectory;

  // Are we running inside a JAWS sandbox?
  private boolean useSandbox = false;

  /**
   * Constructor: set up the user interface
   */
  public PicoDraw() {
    super( "PicoDraw" );

    setupGUI();
    addListeners();
  }

  /**
   * Set up the user interface
   */
  private void setupGUI() {
    Container cp = getContentPane();

    JMenuBar mb = new JMenuBar();
    setJMenuBar( mb );

    JMenu fileMenu = new JMenu( "File" );
    fileMenu.setMnemonic( KeyEvent.VK_F );
    mb.add( fileMenu );

    JMenuItem loadMI = new JMenuItem( "Load", KeyEvent.VK_X );
    loadMI.addActionListener( new ActionListener() {
        public void actionPerformed( ActionEvent ae ) {
          load();
        }
      } );
    fileMenu.add( loadMI );

    JMenuItem saveMI = new JMenuItem( "Save", KeyEvent.VK_X );
    saveMI.addActionListener( new ActionListener() {
        public void actionPerformed( ActionEvent ae ) {
          save();
        }
      } );
    fileMenu.add( saveMI );

    JMenuItem printMI = new JMenuItem( "Print", KeyEvent.VK_X );
    printMI.addActionListener( new ActionListener() {
        public void actionPerformed( ActionEvent ae ) {
          print();
        }
      } );
    fileMenu.add( printMI );

    JMenuItem exitMI = new JMenuItem( "Exit", KeyEvent.VK_X );
    exitMI.addActionListener( new ActionListener() {
        public void actionPerformed( ActionEvent ae ) {
          exit();
        }
      } );
    fileMenu.add( exitMI );

    JMenu backgroundMenu = new JMenu( "Background" );
    backgroundMenu.setMnemonic( KeyEvent.VK_B );
    mb.add( backgroundMenu );
    String backgrounds[] = getBackgrounds();
    for (int i=0; i<backgrounds.length; ++i) {
      final String bgname = backgrounds[i];
      JMenuItem mi = new JMenuItem( bgname );
      mi.addActionListener( new ActionListener() {
        public void actionPerformed( ActionEvent ae ) {
          loadBackground( bgname );
        }
      } );
      backgroundMenu.add( mi );
    }

    JMenu actionMenu = new JMenu( "Action" );
    actionMenu.setMnemonic( KeyEvent.VK_A );
    mb.add( actionMenu );

    JMenuItem toClipboardMI = new JMenuItem( "Image to Clipboard" );
    toClipboardMI.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent ae ) {
        imageToClipboard();
      }
    } );
    actionMenu.add( toClipboardMI );

    JMenuItem instructionsMI = new JMenuItem( "Show Instructions" );
    instructionsMI.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent ae ) {
        showInstructions();
      }
    } );
    actionMenu.add( instructionsMI );

    cp.setLayout( new BorderLayout() );
    drawCanvas = new DrawCanvas();
    cp.add( drawCanvas, BorderLayout.CENTER );

    setSize( 400, 300 );
    setLocation( 40, 40 );
    setVisible( true );
  }

  /**
   * Exit cleanly if window is closed
   */
  private void addListeners() {
    addWindowListener( new WindowListener() {
      public void windowActivated( WindowEvent we ) {
      }
      public void windowClosed( WindowEvent we ) {
      }
      public void windowClosing( WindowEvent we ) {
        exit();
      }
      public void windowDeactivated( WindowEvent we ) {
      }
      public void windowDeiconified( WindowEvent we ) {
      }
      public void windowIconified( WindowEvent we ) {
      }
      public void windowOpened( WindowEvent we ) {
      }
    } );
  }

  /**
   * Load a list of backgrounds from a list within the application
   */
  private String[] getBackgrounds() {
    try {
      // List of backgrounds
      Vector vec = new Vector();

      // Read file from resource
      ClassLoader cl = getClass().getClassLoader();
      InputStream in = cl.getResourceAsStream( backgroundList );
      InputStreamReader isr = new InputStreamReader( in );
      BufferedReader br = new BufferedReader( isr );

      while (true) {
        String line = br.readLine();
        // null line means end of stream
        if (line==null)
          break;

        vec.addElement( line );
      }
      in.close();

      // Turn Vector into array of Strings
      String dummy[] = new String[0];
      return (String[])vec.toArray( dummy );

    } catch( IOException ie ) {

      System.err.println( "Failed to load background list." );
      ie.printStackTrace();

      // Return empty background list
      return new String[0];
    }
  }

  /**
   * Exit cleanly
   */
  private void exit() {
    setVisible( false );

    // Dispose of JFrame resources
    dispose();

    System.exit( 0 );
  }

  /**
   * Write to an output stream: wrap a DataOutputStream
   * around it
   */
  private void write( OutputStream out ) throws IOException {
    write( new DataOutputStream( out ) );
  }

  /**
   * Write document to DataOutputStream
   */
  private void write( DataOutputStream dout ) throws IOException {
    Vector lines = drawCanvas.lines();

    // Write # of lines
    int nlines = lines.size();
    dout.writeInt( nlines );

    // Write endpoints of each line
    for (int i=0; i<nlines; ++i) {
      Line2D line = (Line2D)lines.elementAt( i );
      dout.writeDouble( line.getX1() );
      dout.writeDouble( line.getY1() );
      dout.writeDouble( line.getX2() );
      dout.writeDouble( line.getY2() );
    }
  }

  /**
   * Read from an input stream: wrap a DataInputStream
   * around it
   */
  private void read( InputStream in ) throws IOException {
    read( new DataInputStream( in ) );
  }

  /**
   * Read document from a DataInputStream
   */
  private void read( DataInputStream din ) throws IOException {
    Vector lines = drawCanvas.lines();

    // Remove all existing lines -- loading a document
    // means erasing the existing document, if any
    lines.removeAllElements();

    // Read the # of lines
    int nlines = din.readInt();

    // Read the endpoints of each line
    for (int i=0; i<nlines; ++i) {
      double x1 = din.readDouble();
      double y1 = din.readDouble();
      double x2 = din.readDouble();
      double y2 = din.readDouble();
      Line2D.Double line = new Line2D.Double( x1, y1, x2, y2 );
      lines.addElement( line );
    }
  }

  /**
   * Load, either directly or via the sandbox method
   */
  private void load() {
    if (useSandbox) {
      loadSandbox();
    } else {
      loadDirect();
    }
  }

  /**
   * Save, either directly or via the sandbox method
   */
  private void save() {
    if (useSandbox) {
      saveSandbox();
    } else {
      saveDirect();
    }
  }

  /**
   * Load directly from the filesystem.  If it fails,
   * switch to sandbox mode and try again
   */
  private void loadDirect() {
    try {
      // Let the user pick a file
      File file = chooseFile( this, false );

      FileInputStream fin = new FileInputStream( file );
      read( fin );
      fin.close();
    } catch( SecurityException se ) {
      System.err.println( "Failed to do direct read; "+
                          "using sandbox method...." );

      // Switch to sandbox mode and try again
      useSandbox = true;
      load();
    } catch( IOException ie ) {
      ie.printStackTrace();
    }
  }

  /**
   * Save directly to the filesystem.  If it fails,
   * switch to sandbox mode and try again
   */
  private void saveDirect() {
    try {
      // Let the user pick a file
      File file = chooseFile( this, true );

      FileOutputStream fout = new FileOutputStream( file );
      write( fout );
      fout.close();
    } catch( SecurityException se ) {
      System.err.println( "Failed to do direct write; "+
                          "using sandbox method...." );

      // Switch to sandbox mode and try again
      useSandbox = true;
      save();
    } catch( IOException ie ) {
      ie.printStackTrace();
    }
  }

  /**
   * Load via the sandbox method
   */
  private void loadSandbox() {
    try {
      FileOpenService fos =
        (FileOpenService)ServiceManager.lookup(
          "javax.jnlp.FileOpenService" );

      FileContents fc = fos.openFileDialog( null, null );

      if (fc!=null) {
        InputStream in = fc.getInputStream();
        read( in );

        // Remember what name we used
        lastFilename = fc.getName();
      } else {
        System.err.println( "Open aborted" );
      }

      // We've loaded new data -- draw it
      repaint();
    } catch( UnavailableServiceException use ) {
      use.printStackTrace();
    } catch( IOException ie ) {
      ie.printStackTrace();
    }
  }

  /**
   * Save via the sandbox method.  Use background thread to
   * write to one end of a pipe; the FileSaveService reads
   * from the other end 
   */
  private void saveSandbox() {
    try {
      FileSaveService fss =
        (FileSaveService)ServiceManager.lookup(
          "javax.jnlp.FileSaveService" );

      // Use the filename we last loaded from
      String filename = lastFilename;
      if (lastFilename==null)
        lastFilename = "data.pd";

      PipedInputStream pin = new PipedInputStream();
      final PipedOutputStream pout = new PipedOutputStream( pin );

      Thread writeThread = new Thread( new Runnable() {
        public void run() {
          try {
            write( pout );
            System.out.println( "Background write done." );
          } catch( IOException ie ) {
            System.err.println( "Background write failed!" );
            ie.printStackTrace();
          } finally {
            try {
              pout.close();
            } catch( IOException ie ) {
              System.err.println(
                "Background write failed to close!" );
              ie.printStackTrace();
            }
          }
        }
      } );
      writeThread.start();

      FileContents fc = fss.saveFileDialog( savefileDirectory,
                                            null, pin, filename );

      // Remember what name we used
      if (fc != null)
        lastFilename = fc.getName();
    } catch( UnavailableServiceException use ) {
      use.printStackTrace();
    } catch( IOException ie ) {
      ie.printStackTrace();
    }
  }

  /**
   * Show a generic file chooser for saving and loading.
   */
  public File chooseFile( Component comp, boolean savep ) {
    if (choosingDirectory == null) {
      choosingDirectory =
        new File( System.getProperty( "user.dir" ) );
    }

    JFileChooser jfc = new JFileChooser( choosingDirectory );

    int ret = savep ? jfc.showSaveDialog( comp )
                    : jfc.showOpenDialog( comp );
    if (ret == JFileChooser.APPROVE_OPTION) {
      File file = jfc.getSelectedFile();
      String name = file.getPath();
      choosingDirectory = jfc.getCurrentDirectory();
      file = new File( name );
      return file;
    }
    return null;
  }

  /**
   * Load a background, given its application-side filename
   */
  private void loadBackground( String name ) {
    // Read image from resource
    ClassLoader cl = getClass().getClassLoader();
    URL imageURL = cl.getResource( backgroundDirectory+"/"+name );

    ImageIcon icon = new ImageIcon( imageURL );
    drawCanvas.setBackgroundImage( icon.getImage() );
  }

  /**
   * Print drawing to a printer
   */
  private void print() {
    try {
      PrintService ps =
        (PrintService)ServiceManager.lookup(
          "javax.jnlp.PrintService" );

      boolean ok = ps.print( drawCanvas );

      if (!ok)
        System.err.println( "Unable to print!" );
    } catch( UnavailableServiceException use ) {
      use.printStackTrace();
    }
  }

  /**
   * Bring up instructions in the web browser
   */
  private void showInstructions() {
    boolean ok = true;
    Exception exception = null;

    try {
      BasicService bs = (BasicService)
        ServiceManager.lookup( "javax.jnlp.BasicService" );

      URL url = new URL( instructionsURL );

      ok = bs.showDocument( url );
    } catch( UnavailableServiceException use ) {
      exception = use;
      ok = false;
    } catch( MalformedURLException mue ) {
      exception = mue;
      ok = false;
    }

    // Handle either Exception here
    if (!ok) {
      System.err.println( "Couldn't show instructions.\n"+
                          "Please direct your browser to "+
                          instructionsURL+"." );
      if (exception != null)
        exception.printStackTrace();
    }
  }

  /**
   * Copy image to system clipboard
   */
  private void imageToClipboard() {
    Image image = drawCanvas.getImage();
    TransferableImage ti = new TransferableImage( image );

    try {
      ClipboardService cs =
        (ClipboardService)ServiceManager.lookup(
          "javax.jnlp.ClipboardService" );

      cs.setContents( ti );

    } catch( UnavailableServiceException use ) {
      System.err.println( "Can't get access to clipboard" );
      use.printStackTrace();
    }
  }

  static public void main( String args[] ) {
    new PicoDraw();
  }
}
