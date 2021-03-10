package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class IOutils {
    public List<String> readStopWords(){
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
