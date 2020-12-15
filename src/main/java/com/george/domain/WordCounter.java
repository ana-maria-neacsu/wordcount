package com.george.domain;

import java.util.Arrays;
import java.util.Scanner;

public class WordCounter {

    public long count(String word) {
        String[] words = word.split(" ");
        long totalWords = 0;
        for (String s : words){
            if (s.matches("[a-zA-Z]+")){
                totalWords++;
            }
        }

//        long totalWords = Arrays.stream(words).filter(s -> s.matches("[a-zA-Z]")).count();
        return totalWords;

    }
}
