package com.home.corejavav2.collectorsOptionalsDataProcessing.M03;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Gaurav Rehan
 */
public class ParallelStreams {

    public static void main(String[] args) {
        
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2") ;
        
        //List<String> strings = new CopyOnWriteArrayList<>();
        List<String> strings = new CopyOnWriteArrayList<>();
        
        List<String> collect = 
                Stream.iterate("+", s -> s + "+")
                .parallel()
                .limit(1000)
                 //.peek(s -> System.out.println(s + " processed in the thread " + Thread.currentThread().getName()))
                // .forEach(s -> strings.add(s));
                .collect(Collectors.toList());
        
        System.out.println("# " + collect.size());
        //collect.forEach(System.out::println);
    }
}
