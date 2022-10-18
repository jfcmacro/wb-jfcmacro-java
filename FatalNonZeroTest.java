public class FatalNonZeroTest {

    public void processData() throws @Fatal Exception {
        double value = getValue();
        int roundedValue = (@NonZero int) value;

        FatalNonZeroTest fnzt = new @Fatal FatalNonZeroTest();
    }

    public double getValue() {
        double value = 198.98;
        return value;
    }
}
