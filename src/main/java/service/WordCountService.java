package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordCountService {

    public int countWords(String text){
        return (int)Arrays.stream(text.split("\\s+")).filter(t->
                t.matches("[a-zA-Z]+")).count();
    }

    private List<String> intitializeStopWords(){
        List<String> stopWords = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/stopwords.txt")))){
            while(reader.ready())
                stopWords.add(reader.readLine());

        } catch (IOException e){
            return stopWords;
        }
        return stopWords;
    }
}
