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
        long uniqueWordsCount = new HashSet<>(preparedList).size();

        return new CountResult(wordsCount, uniqueWordsCount);

    }
}
