package com.home.corejavav2.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class E12StreamReduction {
    public static void main(String[] args) {

        //stream of first 10 numbers
        Stream<Integer> intStream = Stream.<Integer>iterate(0, n -> n + 1).limit(10);
        //reduce to sum
        Optional<Integer> sum = intStream.reduce((x, y) -> x + y);

    }
}
