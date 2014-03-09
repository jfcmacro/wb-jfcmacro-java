import java.util.List;
import java.util.Vector;
import java.util.Iterator;

public class ListTest {
    
    public static void main(String [] args) {
	List<Integer> li = new Vector<Integer>();
	li.add(1);
	li.add(2);
	li.add(3);
	for (Integer i : li) {
	    System.out.println("Valor: " + i);
	}
	List ls = new Vector();
	ls.add( "Uno");
	ls.add("Dos");
	ls.add("Tres");
	for (Iterator i = ls.iterator(); i.hasNext(); ) {
	    String valor = (String) i.next();
	    System.out.println("Valor: " + valor);
	}
	List<List<Integer>> lli = new Vector<List<Integer>>();
	lli.add(new Vector<Integer>());
	List<Integer> lt = lli.get(0);
	lt.add(1);
	lt.add(2);
	
    }
}