import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class TestCollectorToList {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
            

        List<Integer> listInt =  map.values().stream().map(i -> i + 1).collect(new CollectorToList<>());
        List<String> listStr  =  map.keySet().stream().map(s -> "xxx" + s).collect(new CollectorToList<>());

        System.out.println(listInt);
        System.out.println(listStr);
    }
}
