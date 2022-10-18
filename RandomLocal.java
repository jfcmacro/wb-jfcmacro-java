public class RandomLocal {
    public RandomInteger getRandomInteger() {
        class RandomIntegerLocal extends RandomInteger {
            @Override
            public int getValue() {
                long n1 = rand.nextInt();
                long n2 = rand.nextInt();

                int value = (int) ((n1 + n2)/2);
                return value;
            }
        }

        return new RandomIntegerLocal();
    }
}
