package com.home.devvox;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Gaurav on 07-01-2017.
 */
public class Streams {


    public static void main(String... args)

    {

        List<Integer> numbers = Arrays.asList(5, 4, 3, 2, 6, 7, 8, 9, 10);
        //use of streams

        /*numbers.stream()
                .map(Object::toString)
                .forEach(System.out::println);
*/

/*
//  Reduction example. stream elements are reduced.
        System.out.println(
        numbers.stream()
//                .reduce(0, (total, e) -> Integer.sum(total, e))
                .reduce(0, Integer::sum)
        );
*/

/*
//  Reduction another example.
        System.out.println(
        numbers
                .stream()
                .map(String::valueOf)
                //.reduce("", (carry, e) -> carry.concat(e));
                .reduce("", String::concat)
        );*/


        // double and sum the even numbers
        System.out.println(
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .reduce(0, (sm, e) -> Integer.sum(sm, e))
        );
    }
}
