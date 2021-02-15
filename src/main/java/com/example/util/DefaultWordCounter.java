package com.example.util;

import com.example.WordCounter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultWordCounter implements WordCounter {

    @Override
    public int countWords(String inputText) {

        List<String> separated = Arrays.asList(inputText.split(" "));
        Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);

        int counter = 0;
        for (String word : separated) {
            Matcher m = p.matcher(word);
            if (!m.find()){
                counter++;
            }
        }
        return counter;
    }
}
