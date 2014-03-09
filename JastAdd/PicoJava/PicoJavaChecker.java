import AST.*;

import java.util.*;
import java.io.*;

class PicoJavaChecker {
  public static void main(String args[]) {
    if(args.length != 1) {
      System.out.println("PicoJavaChecker expects a single file name as command line argument");
      System.exit(1);
    }
    PicoJavaParser parser = new PicoJavaParser();
    try {
      String name = args[0];
      Reader reader = new FileReader(name);
      PicoJavaScanner scanner = new PicoJavaScanner(new BufferedReader(reader));
      Program p = (Program)parser.parse(scanner);
      reader.close();
      Collection errors = p.errors();
      if(!errors.isEmpty()) {
        for(Iterator iter = errors.iterator(); iter.hasNext(); )
          System.out.println(iter.next());
      }
      else {
        System.out.println("OK");
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return;
    } catch (IOException e) {
      System.err.println(e);
      e.printStackTrace();
      return;
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
      return;
    }
  }
}
