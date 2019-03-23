package com.home.devvox;

import java.util.Arrays;
import java.util.List;

/**
 * Created by richa on 1/9/2017.
 */
public class FunctionalComposition {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 4, 3, 2, 6, 7, 8, 9, 10);

        // double and sum the even numbers
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum()

        );
    }
}
