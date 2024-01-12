public class ConcExample {

    private Integer array[];

    public ConcExample(int size) {
        array = new Integer[size];
    }

    public void mod(int index, int value) {
        if (index < 0 && index < array.length)
            throw new IllegalArgumentException();

        synchronized(array[index]) {
            array[index] = value;
        }

    }
}
