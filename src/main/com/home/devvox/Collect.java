package com.home.devvox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

/**
 * Created by richa on 1/9/2017.
 */
public class Collect {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);

/*
        // double and sum the even numbers
        List<Integer> doubleOfEven = null;

        //Avoid shared mutability - make use of collectors -  below is good example.
        doubleOfEven =
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .collect(toList());

        System.out.println(doubleOfEven);
*/

        // double and sum the even numbers
        Set<Integer> doubleOfEven = null;

        //Avoid shared mutability - make use of collectors -  below is good example.
        doubleOfEven =
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .collect(toSet());

        System.out.println(doubleOfEven);




    }
}
