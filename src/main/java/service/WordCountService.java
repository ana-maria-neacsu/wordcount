package service;

import java.util.Arrays;

public class WordCountService {

    public int countWords(String text){
        return (int)Arrays.stream(text.split("\\s+")).filter(t->
                t.matches("[a-zA-Z]+")).count();
    }
}
