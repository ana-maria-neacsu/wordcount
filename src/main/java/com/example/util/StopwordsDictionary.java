package com.example.util;

import java.util.HashSet;
import java.util.List;

public class StopwordsDictionary {
    private HashSet<String> stopWords = new HashSet<>();

    public void loadStopWords(List<String> words) {
        if (words != null) {
            for (String word : words) {
                if (!word.isEmpty()) {
                    stopWords.add(word);
                }
            }
        }
    }

    public HashSet<String> getStopWords() {
        return stopWords;
    }
}
