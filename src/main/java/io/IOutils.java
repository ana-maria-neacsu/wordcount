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

    public static String createOutput(int numberOfWords,int numberOfUniqueWords, double averageLength,
                                       List<String> indices, boolean printIndex){
        String output =  "Number of Words: " + numberOfWords + ", unique: " + numberOfUniqueWords
                + "; average word length: " + averageLength + " characters";
        if(printIndex)
            output += "/n" + printIndex(indices);
        return output;
    }

    private static String printIndex(List<String> indices){
        StringBuilder output = new StringBuilder("Index:\n");
        indices.stream().forEach(s -> output.append(s + "\n"));
        return output.toString();
    }
}
