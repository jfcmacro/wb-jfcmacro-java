package co.edu.eafit.dis.tex2sylla;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TeX2Sylla {

   public static void main(String args[]) {

      try {
         TeX2SyllaLex t2sLexer = new TeX2SyllaLex(new FileReader(args[0]));
         while (t2sLexer.yylex() != 0) {
         }
      }
      catch (FileNotFoundException fnfe) {
      }
      catch (IOException ioe) {
      }
      catch (Exception e) {
      }
   }
}
