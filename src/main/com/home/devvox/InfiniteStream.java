package com.home.devvox;

import java.util.stream.Stream;

/**
 * Created by richa on 1/9/2017.
 */
public class InfiniteStream {

    public static void main(String[] args) {

        //this is an example of infinte stream. this gives a series 100, 101, 102...
        //streams are smart. it doesn't print the series because there is no compuation happenning
        //System.out.println(Stream.iterate(100, e -> e + 1));
        //look at below complex usecase simplified by use of infinite streams
        System.out.println(
                Stream.iterate(100, e -> e + 1) //unbounded and lazy
                .filter(e -> e % 2 ==0) //allow even to pass - unbounded and lazy
                .filter(e -> Math.sqrt(e) > 20) // unbounded and lazy
                .mapToInt(e -> e * 2) //unbounded and lazy
                .limit(5) //limit to n numbers -- sized and lazy
                .sum() //sum is that the one that triggers the calculaton
        );

    }
}
