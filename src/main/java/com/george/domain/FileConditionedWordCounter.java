package com.george.domain;

import com.george.ports.FileReader;

import java.util.Arrays;

public class FileConditionedWordCounter implements WordCounter {

    private final String stopWords;

    public FileConditionedWordCounter(String stopWords) {
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
