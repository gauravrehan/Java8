package com.home.devvox;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Hello world!
 *
 */
public class ComparatorImpl {
    public static void main(String[] args) {
        String [] sArray = new String[] {"Gaurav", "Rehan", "Aarav", "Rehan", "Richa"};
        //Arrays.sort(sArray, getStringComparator());
        Arrays.sort(sArray, getStringComparatorLambda());
        System.out.println(Arrays.toString(sArray));
    }


    public static Comparator<String> getStringComparator() {
        Comparator<String> stringComparator = new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareToIgnoreCase(b);
            }
        };
        return stringComparator;
  }

    public static Comparator<String> getStringComparatorLambda()
    {
        //WE can use final modifier on the lambda expression parameter but we have to also definre the parameter type too. Just final a, final b doesnt work.
        //In addition to final keyword we can also specify Annotations
        //It is not possible to define return type of the lambda expression.
        Comparator<String> stringComparator = (final String a, final String b) -> a.compareToIgnoreCase(b);
        return stringComparator;
    }
}