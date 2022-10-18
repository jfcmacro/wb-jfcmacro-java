package org.jfcmc.generics;

public class WrapperUtil {
    public static void printDetails(Wrapper<?> wrapper) {
        Object value = wrapper.get();
        String className = null;

        if (value != null) {
            className = value.getClass().getName();
        }

        System.out.println("Class: " + className);
        System.out.println("Value: " + value);
    }

    public static double sum(Wrapper<? extends Number> num1,
                             Wrapper<? extends Number> num2) {
        Number n1 = num1.get();
        Number n2 = num2.get();

        double sum = n1.doubleValue() + n2.doubleValue();
        return sum;
    }

    public static <T> void copy(Wrapper<T> source, Wrapper<? super T> dest) {
        T value = source.get();
        dest.set(value);
    }
}
