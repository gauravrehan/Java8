package com.home.corejavav2.collectorsOptionalsDataProcessing.M01;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.home.corejavav2.collectorsOptionalsDataProcessing.M01.model.Person;



/**
 *
 * @author Gaurav Rehan
 */
public class CreatingSpliterator {

    public static void main(String[] args) {
        
        Path path = Paths.get("/Users/gauravrehan/Documents/c/Java8/src/main/com/home/corejavav2/collectorsOptionalsDataProcessing/M01/files/people.txt");
        
        try (Stream<String> lines = Files.lines(path);) {
            
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);
            
            Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
            people.forEach(System.out::println);
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
