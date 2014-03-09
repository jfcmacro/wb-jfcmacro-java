
import java.util.*;

public class Test {

	public static void main(String args[]) {

		List<Integer> myIntList = new LinkedList<Integer>();
		myIntList.add(new Integer(0));
		Integer x = myIntList.iterator().next();
		System.out.println("Valor: " + x);
	}

}
