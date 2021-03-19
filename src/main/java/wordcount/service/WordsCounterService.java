package wordcount.service;

import wordcount.contract.StopWords;

import java.util.Arrays;

public class WordsCounterService {
    private StopWords stopWords;

    public WordsCounterService(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    public long countWords(String text) {
        return Arrays.stream(text.split("[\\s]+"))
                .filter(word -> word.matches("[a-zA-Z]+"))
                .filter(validWord -> !stopWords.loadStopWordsFromClassPath().contains(validWord))
                .count();
    }
}
