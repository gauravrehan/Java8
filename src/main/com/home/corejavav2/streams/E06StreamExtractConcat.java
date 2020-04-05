package com.home.corejavav2.streams;

import java.util.stream.Stream;

public class E06StreamExtractConcat {
    public static void main(String[] args) {
        //limiting an infinite steam - using limit
        Stream<Double> generateRandom = Stream.generate(Math::random).limit(5);
        generateRandom.forEach(System.out::println);

        //skip first 2 elements
        Stream<Double> generateRandomSkip = Stream.generate(Math::random).limit(5).skip(2);
        generateRandomSkip.forEach(System.out::println);

        //Concat 2 streams
        //the first stream should not be infinite otherwize the second stream will not be called at all.
        Stream<String> song = Stream.of("gentle", "black", "yellow", "black");
        Stream<String> song1 = Stream.of("gentle1", "black1", "yellow1", "black1");
        Stream.concat(song, song1).forEach(System.out::println);

        //distinct
        Stream<String> song2 = Stream.of("gentle1", "black1", "yellow1", "black1");
        song2.distinct().forEach(System.out::println);

        //peek. helps in debugging as below we can set breakpoints for debugging
        Stream<String> song3 = Stream.of("gentle1", "black1", "yellow1", "black1");
        song3.peek(s -> System.out.println("peek ="+ s)).distinct().peek(s -> System.out.println("peekdis ="+ s)).count();




    }
}
