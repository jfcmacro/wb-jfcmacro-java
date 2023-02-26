import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class CollectorToList<E> implements Collector<E,List<E>,List<E>> {

    public BiConsumer<List<E>,E> accumulator() {
        return (accum, elem) -> accum.add(elem);
    }

    public Set<Collector.Characteristics> characteristics() {
        return new HashSet<>();
    }

    public BinaryOperator<List<E>> combiner() {
        return (leftList,rightList) -> {
            leftList.addAll(rightList);
            return leftList;
        };
    }

    public Function<List<E>,List<E>> finisher() {
        return list -> list;
    }

    public Supplier<List<E>> supplier() {
        return ArrayList::new;
    }
}
