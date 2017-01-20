import java.util.Arrays;
import java.util.List;

public class ArraysTest {

   public static void printElementsList(List<String> ls) {
      for (String s : ls) {
         System.out.println(s);
      }
   }

   public static void main(String []args) {
      List<String> ls = Arrays.asList("Uno", "dos", "tres");
      printElementsList(ls);
      List<String> ls2 = Arrays.asList("Uno", null, "dos");
      printElementsList(ls2);
   }
}
