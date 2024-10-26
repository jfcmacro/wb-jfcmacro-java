import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class CollectMapExample {

    public static void main(String...args) {
        String[] array = { "a", "a", "b", "b", "c", "a", "c", "a", "d" };

        Map<String,Integer> map = Arrays.stream(array)
            .collect(toMap(identity(),
                           (str) -> 1,
                           (v,nv) -> v + nv));

        System.out.println(map);
    }
}
                         
