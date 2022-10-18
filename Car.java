public class Car {
    private int year;

    public class Tire {
        private double radius;

        public Tire(double radius) {
            this.radius = radius;
        }

        public double getRadious() {
            return radius;
        }
    }

    public Car(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
