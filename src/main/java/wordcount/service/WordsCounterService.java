package wordcount.service;

import wordcount.contract.StopWords;

import java.util.Arrays;
import java.util.stream.Stream;

public class WordsCounterService {
    private StopWords stopWords;

    public WordsCounterService(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    public long countWords(String input) {
        return getStringStream(input)
                .count();
    }

    public long countUniqueWords(String input) {
        return getStringStream(input)
                .distinct()
                .count();
    }

    public double countWordsAverage(String input) {
        return getStringStream(input)
                .mapToInt(String::length)
                .average().orElse(0.0);

    }

    private Stream<String> getStringStream(String text) {
        return Arrays.stream(text.split("[\\s]+"))
                .filter(word -> word.matches("[a-zA-Z-]+\\.?"))
                .filter(validWord -> !stopWords.loadStopWordsFromClassPath().contains(validWord));
    }
}
