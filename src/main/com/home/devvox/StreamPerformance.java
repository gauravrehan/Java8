package com.home.devvox;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by richa on 1/9/2017.
 */
public class StreamPerformance {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

//        if i want to find the first element which is greater than 3 , even and return double of it.


        //Streams are lazy evaluation
        // the way streams work is they pick one element and pass it through each filter/map operation.
        //findfirst is the terminal terminal method which trigers the computations. if this line is ommitted, no stream
        //pipelne is built ever. Try it yourself, you will not see isGT# etc getting called

        System.out.println(
        numbers.stream()
                .filter(StreamPerformance::isGT3)
                .filter(StreamPerformance::isEven)
                .map(StreamPerformance::doubleIt)
                .findFirst()
        );

    }

    public static boolean isGT3(Integer number)
    {
        System.out.println("isGT3 called for value " + number);
        return number > 3;
    }

    public static boolean isEven(Integer number)
    {
        System.out.println("Is Even is called for value " + number);
        return number % 2 == 0;
    }

    public static Integer doubleIt(Integer number)
    {
        System.out.println("doubleId is called for value " + number);
        return number * 2;
    }
}
