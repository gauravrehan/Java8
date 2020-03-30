package com.home.corejavav2.streams;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class E03StreamFilter {
    public static void main(String[] args) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\richa\\Documents\\code\\Java8\\src\\main\\com\\home\\corejavav2\\streams\\alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        //System.out.println(words.toString());
        long count = words.stream().filter(w -> w.length() > 8).count();
        System.out.println("Large words in count: " + count + " Total word count is: " + words.size());

    }
}
