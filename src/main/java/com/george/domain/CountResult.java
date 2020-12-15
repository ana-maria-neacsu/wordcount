package com.george.domain;

public class CountResult {

    private final long totalWords;
    private final long uniqueWords;
    private final Double average;

    public CountResult(long totalWords, long uniqueWords) {
        this.totalWords = totalWords;
        this.uniqueWords = uniqueWords;
        average = (Double.valueOf(totalWords) + Double.valueOf(uniqueWords) / 2);

    }

    public long getTotalWords() {
        return totalWords;
    }

    public long getUniqueWords() {
        return uniqueWords;
    }

    public Double getAverage() { return average; }

}
