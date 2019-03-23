package com.home.devvox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by richa on 1/9/2017.
 */
public class StreamProperties {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);


        //Streams have properties like:
        // sized - i know that the stream is based on a list so it is bounded and sized.
//        ordered - i know that the stream is based on a list so it is got to be ordered.
//        distinct - Look below how i am sorting the stream elements and getting distincts
//        sorted

        numbers.stream()
                .filter(e -> e % 2 == 0)
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }
}

