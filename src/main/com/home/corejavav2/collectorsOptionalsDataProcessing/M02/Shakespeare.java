package com.home.corejavav2.collectorsOptionalsDataProcessing.M02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 *
 * @author Gaurav Rehan
 */
public class Shakespeare {

    public static void main(String[] args) throws IOException {
        // http://introcs.cs.princeton.edu/java/data/words.shakespeare.txt
        // http://introcs.cs.princeton.edu/java/data/ospd.txt
        
        Set<String> shakespeareWords = 
            Files.lines(Paths.get("/Users/gauravrehan/Documents/c/Java8/src/main/com/home/corejavav2/collectorsOptionalsDataProcessing/M02/files/words.shakespeare.txt"))
                .map(word -> word.toLowerCase())
                .collect(Collectors.toSet());
        
        Set<String> scrabbleWords =
            Files.lines(Paths.get("/Users/gauravrehan/Documents/c/Java8/src/main/com/home/corejavav2/collectorsOptionalsDataProcessing/M02/files/ospd.txt"))
                .map(word -> word.toLowerCase())
                .collect(Collectors.toSet());
        
        System.out.println("# words of Shakespeare : " + shakespeareWords.size());
        System.out.println("# words of Scrabble : " + scrabbleWords.size());
        
        final int [] scrabbleENScore = {
     // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y,  z
        1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10} ;
        
        Function<String, Integer> score = 
                word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();
        
        ToIntFunction<String> intScore = 
                word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();
        
        System.out.println("Score of hello: " + intScore.applyAsInt("hello"));
        
        String bestWord = 
        shakespeareWords.stream()
                .filter(word -> scrabbleWords.contains(word))
                .max(Comparator.comparing(score))
                .get();
        
        System.out.println("Best word: " + bestWord);
        
        IntSummaryStatistics summaryStatistics = 
            shakespeareWords.stream().parallel()
                .filter(scrabbleWords::contains)
                .mapToInt(intScore)
                .summaryStatistics();
        
        System.out.println("Stats: " + summaryStatistics);
    }
}
