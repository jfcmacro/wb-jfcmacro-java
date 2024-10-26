import java.util.Arrays;
import java.util.function.Predicate;

public class Exercise01 {

    private static int nextPred(int[] vector, int startPos,
                               Predicate<Integer> pred){
        int index = startPos;
        for (;index < vector.length; index++) {
            if (pred.test(vector[index])) {
                break;
            }
        }

        return index < vector.length ? index : -1;
    }

    private static int nextEven(int[] vector, int startPos) {
        return nextPred(vector, startPos, (i) -> i % 2 == 0);
    }

    private static int nextOdd(int[] vector, int startPos) {
        return nextPred(vector, startPos, (i) -> i % 2 == 1);
    }

    private static void swap(int[] vector, int first, int second) {
        int tmp = vector[first];
        vector[first] = vector[second];
        vector[second] = tmp;
    }

    public static void orderEvenBeforeOdd(int[] vector) {

        int i = 0;

        while (i < vector.length) {
            int even = nextEven(vector, i);
            int odd = nextOdd(vector, i);

            if (even == -1 || odd == -1) {
                break;
            }

            if (even < odd) {
                i = even + 1;
                continue;
            }

            swap(vector, even, odd);

            i = odd + 1;
        }
    }

    private static int[] toArray(int...args) {
        return Arrays.copyOf(args, args.length);
    }

    public static void main(String...args) {

        int[] array = { 1, 3, 5 };

        System.out.println(Arrays.toString(array));

        orderEvenBeforeOdd(array);

        System.out.println(Arrays.toString(array));

        array = toArray(1,2,3,4,5,6);

        System.out.println(Arrays.toString(array));

        orderEvenBeforeOdd(array);

        System.out.println(Arrays.toString(array));

        array = toArray(2,4,6,8);

        System.out.println(Arrays.toString(array));

        orderEvenBeforeOdd(array);

        System.out.println(Arrays.toString(array));

        array = toArray(2,1,4,3,6,5);

        System.out.println(Arrays.toString(array));
    }
}
