package com.home.corejavav2.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E09StreamCollectors {
    public static void main(String[] args) {
        Stream<String> words01  = Stream.of("gentle1", "black1", "yellow1", "black1");
        //collecting in an array
        String[] sArray = words01.toArray(String[]::new);
        System.out.println(Arrays.toString(sArray));

        Stream<String> words02  = Stream.of("gentle1", "black1", "yellow1", "black1");
        //collecting in a list
        List<String> list = words02.collect(Collectors.toList());
        System.out.println(list);

        Stream<String> words03  = Stream.of("gentle1", "black1", "yellow1", "black1");
        //collecting in a set
        Set<String> set = words03.collect(Collectors.toSet());
        System.out.println(set);


        Stream<String> words04  = Stream.of("gentle1", "black1", "yellow1", "black1");
        //collecting in a specific type of set
        Set<String> setTree = words04.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(setTree);

        //Concatenating a list of strings
        Stream<String> words05  = Stream.of("gentle1", "black1", "yellow1", "black1");
        String concatStr = words05.collect(Collectors.joining(", "));
        System.out.println(concatStr);

        //Summarized statistics
        Stream<String> words06  = Stream.of("gentle1", "black1", "yellow1", "black1");
        IntSummaryStatistics intSummary = words06.collect(Collectors.summarizingInt(String::length));
        System.out.println(intSummary.getAverage());


    }
}
