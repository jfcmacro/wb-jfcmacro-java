package org.jfcmc.streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalTest2 {
    public static void main(String[] args) {
        IntStream.of(10, 20, 30)
            .filter(n -> n % 2 == 1)
            .max()
            .ifPresentOrElse(value -> System.out.println("Maximum odd integer is " + value),
                             () -> System.out.println("Stream is empty"));

        IntStream.of(1, 10, 37, 20, 31)
            .filter(n -> n % 2 == 1)
            .max()
            .ifPresentOrElse(value -> System.out.println("Maximum odd integer is " + value),
                             () -> System.out.println("Stream is empty"));

        Stream.of("Ken", "Ellen", "Li")
            .max(Comparator.comparingInt(String::length))
            .ifPresentOrElse(value -> System.out.println("Longest name is " + value),
                             () -> System.out.println("Stream is empty"));
    }
}
