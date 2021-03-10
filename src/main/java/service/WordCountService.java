package service;

import java.util.Arrays;
import java.util.List;

public class WordCountService {

    public int countWords(String text, List<String> stopWords){
        return (int)Arrays.stream(text.split("\\s+")).filter(t->
                t.matches("[a-zA-Z]+"))
                .filter(t -> !stopWords.contains(t))
                .count();
    }
}
