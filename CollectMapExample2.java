import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class CollectMapExample2 {

    public static void main(String...args) {
        String[] array = { "a", "a", "b", "b", "c", "a", "c", "a", "d" };

        Map<String,List<String>> map = Arrays.stream(array)
            .collect(toMap(identity(),
                           (str) -> {
                               List<String> list = new ArrayList<>();
                               list.add(str);
                               return list;
                           },
                           (lst1,lst2) -> {
                               lst1.addAll(lst2);
                               return lst1;
                           }));

        System.out.println(map);
    }
}
                         
