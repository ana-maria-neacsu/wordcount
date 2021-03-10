package service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class WordCountService {

    public int countWords(String text, List<String> stopWords){
        return (int)Arrays.stream(text.split("\\s+")).filter(t->
                t.matches("[a-zA-Z-.]+"))
                .filter(t -> !stopWords.contains(t))
                .count();
    }

    public int countUniqueWords(String text, List<String> stopWords){
        return (int)Arrays.stream(text.split("\\s+")).filter(t->
                t.matches("[a-zA-Z-.]+"))
                .filter(t -> !stopWords.contains(t))
                .distinct()
                .count();
    }


}
