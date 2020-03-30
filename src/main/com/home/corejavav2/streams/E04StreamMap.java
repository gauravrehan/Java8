package com.home.corejavav2.streams;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class E04StreamMap {
    public static void main(String[] args) throws Exception{
        String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\richa\\Documents\\code\\Java8\\src\\main\\com\\home\\corejavav2\\streams\\alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        //words.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        //other way write
        //words.stream().map(String::toUpperCase).forEach(System.out::println);
        //print first char for each word
        words.stream().map(s -> s.substring(0,1)).forEach(System.out::println);
    }
}
