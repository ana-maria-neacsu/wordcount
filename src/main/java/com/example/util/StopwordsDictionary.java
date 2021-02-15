package com.example.util;

import java.util.HashSet;
import java.util.List;

public class StopwordsDictionary {
    private HashSet<String> stopWords;

    public void loadStopWords(List<String> words) {
        for (String word : words) {
            stopWords.add(word);
        }
    }

    public HashSet<String> getStopWords() {
        return stopWords;
    }
}
