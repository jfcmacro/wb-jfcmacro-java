
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class TestMap {

    public static void main(String args[]) {
	Map<String, ArrayList<String> > map =
	    new HashMap<String, ArrayList<String> >();

	ArrayList<String> al = new ArrayList<String>();

	al.add("Tarea1");
	al.add("Tarea2");

	map.put("Inicio", al);

	al = new ArrayList<String>();
	al.add("Tarea3");

	map.put("Tarea1", al);

	ArrayList<String> next = map.get("Inicio");

	for (String sig : next) {
	    System.out.println(sig);
	}

    }
}
