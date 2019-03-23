package com.home.devvox;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.*;

/**
 * Created by richa on 1/5/2017.
 */
public class Lambdas {

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(new Integer[]{5, 4, 3, 2, 6, 7, 8, 9, 10});

        //Lambda with anonymous class
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //A bit elaborated lambda expression
        numbers.forEach((Integer i) -> {
            System.out.println(i);
        });

        //Further code reduction
        numbers.forEach((i) -> System.out.println(i));

        //Further code reduction
        numbers.forEach(i -> System.out.println(i));

        //Since we are just doing a give and take of parameter i, we can just get rid of "->" and "i"
        //and make it a method reference
        numbers.forEach(System.out::println);

        //the line 42 is a method reference to a static method where as line 43 is method reference to an instance method.
        numbers
                .stream()
                .map(String::valueOf)
                .forEach(System.out::println);
    }
}
