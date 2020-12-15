package com.george.domain.filebasedcounter;

import com.george.domain.WordCounter;

import java.util.Arrays;

public class StopWordsConditionedWordCounter implements WordCounter {

    private final String stopWords;

    public StopWordsConditionedWordCounter(String stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public long count(String word) {

        return Arrays.stream(
                word.split(" "))
                .filter(s -> s.matches("[a-zA-Z]+"))
                .filter(s -> !stopWords.contains(s))
                .count();
    }
}
