package com.home.corejavav2.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class E05StreamFlatMap {
    public static void main(String[] args) {
        //if there s method the results in stream, then when we create stream of map using that function that can
        //result into a stream of stream like Stream<Stream<String> stream
        //to avoid this we can flatten the result using flatMap
        Stream<String> song = Stream.of("gentle", "black", "yellow", "black");
        Stream<String> streamOfStream = song.flatMap(w -> letters(w));
        streamOfStream.forEach(System.out::println);

    }
     private static Stream<String> letters(String word)
     {
         List<String> s = new ArrayList<>();
         for(int i=0; i < word.length(); i++)
         {
             s.add(word.substring(i, i+1));
         }
         return s.stream();
     }
}
