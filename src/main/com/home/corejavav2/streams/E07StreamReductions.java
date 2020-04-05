package com.home.corejavav2.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class E07StreamReductions {
    public static void main(String[] args) {
        // reductions reduce the stream to a single value like count, max, min, findany, anymatch, findfirst
        Stream<String> words = Stream.of("gentle1", "black1", "yellow1", "black1");
        Optional<String> maxString = words.max(String::compareToIgnoreCase);
        System.out.println(maxString.get());

        Stream<String> words1  = Stream.of("gentle1", "black1", "yellow1", "black1");
        Optional<String> minString = words1.min(String::compareToIgnoreCase);
        System.out.println(minString.get());

        Stream<String> words2  = Stream.of("gentle1", "black1", "yellow1", "black1");
        Optional<String> findFirstString = words2.filter(s -> s.equalsIgnoreCase("blqack1")).findFirst();
        System.out.println(findFirstString.orElse(""));

        Stream<String> words3  = Stream.of("gentle1", "black1", "yellow1", "black1");
        Optional<String> findAnytString = words3.parallel().filter(s -> s.equalsIgnoreCase("gentle1")).findAny();
        System.out.println(findAnytString.orElse(""));


        Stream<String> words4  = Stream.of("gentle1", "black1", "yellow1", "black1");
        boolean findAnyMatchtString = words4.parallel().anyMatch(s -> s.equalsIgnoreCase("gentle1"));
        System.out.println(findAnyMatchtString);


    }
}
