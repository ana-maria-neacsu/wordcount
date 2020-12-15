package com.george.domain;

public class CountResult {

    private final long totalWords;
    private final long uniqueWords;
    private final Double averageLength;

    public CountResult(long totalWords, long uniqueWords, Double average) {
        this.totalWords = totalWords;
        this.uniqueWords = uniqueWords;
        averageLength = average;

    }

    public long getTotalWords() {
        return totalWords;
    }

    public long getUniqueWords() {
        return uniqueWords;
    }

    public Double getAverageLength() { return averageLength; }

}
