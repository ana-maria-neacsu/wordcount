package com.george.domain;

public class CountResult {

    private final long totalWords;
    private final long uniqueWords;

    public CountResult(long totalWords, long uniqueWords) {
        this.totalWords = totalWords;
        this.uniqueWords = uniqueWords;
    }

    public long getTotalWords() {
        return totalWords;
    }

    public long getUniqueWords() {
        return uniqueWords;
    }
}
