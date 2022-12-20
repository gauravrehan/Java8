package com.home.corejavav2.collectorsOptionalsDataProcessing.M03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
This is to demonstrate that while using parallel and writing to a non thread safe collection, we will encounter race condition etc.
avoid using thread unsafe collections while writing.
and try to use framework level collectors which take care of parallelism.
 */
public class UnsafeToUseParallelStreamCareful {

    public static void main(String[] args) {

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2") ;

        //List<String> strings = new CopyOnWriteArrayList<>();
        List<String> strings = new ArrayList<>();


                Stream.iterate("+", s -> s + "+")
                        .parallel()
                        .limit(1000)
                        //.peek(s -> System.out.println(s + " processed in the thread " + Thread.currentThread().getName()))
                        .forEach(s -> strings.add(s));
                        //.collect(Collectors.toList());

        System.out.println("# " + strings.size());
        //collect.forEach(System.out::println);
    }
}
