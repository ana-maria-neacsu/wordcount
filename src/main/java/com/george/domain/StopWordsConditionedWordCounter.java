package com.george.domain;

import java.util.HashSet;
import java.util.List;

public class StopWordsConditionedWordCounter implements WordCounter {

    private final WordPreparator preparator;

    public StopWordsConditionedWordCounter(String stopWords) {
        this.preparator = new WordPreparator(stopWords);
    }

    public CountResult count(String word) {

        List<String> preparedList = preparator.prepare(word);
        long wordsCount = preparedList.size();
        HashSet<String> uniqueWords = new HashSet<>(preparedList);
        long uniqueWordsCount = uniqueWords.size();
        Double average = calculateAverage

        return new CountResult(wordsCount, uniqueWordsCount);

    }
}
