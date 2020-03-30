package com.home.corejavav2.streams;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class E02StreamCreation {
    public static void main(String[] args) {
        //stream from a know set of string or array
        Stream<String> song = Stream.of("gentle", "black", "yellow", "black");
        System.out.println(song.count());

        //stream from array
        String[] strArray = new String[3];
        strArray[0] = "black";
        strArray[1] = "green";
        strArray[2] = "yellow";
        Stream<String> streamFromArray = Arrays.stream(strArray, 0,3);
        System.out.println(streamFromArray.count());

        //empty stream
        Stream<String> emptyStream = Stream.<String>empty();

        //infinite streams
        //generate results in infinite stream. using limit to make it stop
        Stream<String> generateEcho = Stream.generate(() -> "Echo").limit(25);
        generateEcho.forEach(System.out::println);
        //generate results in infinite stream. using limit to make it stop
        Stream<Double> generateRandom = Stream.generate(Math::random).limit(25);
        generateRandom.forEach(System.out::println);

        //infinite streams
        //iterate results in infinite stream.
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(3);
        integers.forEach(System.out::println);

    }
}
