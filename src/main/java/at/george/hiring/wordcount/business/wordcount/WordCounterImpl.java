package at.george.hiring.wordcount.business.wordcount;

import at.george.hiring.wordcount.business.stopword.StopWordsLoader;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class WordCounterImpl implements WordCounter {

    private final StopWordsLoader stopWordsLoader;
    private final Pattern isValidWordPattern;

    public WordCounterImpl(StopWordsLoader stopWordsLoader) {
        this.stopWordsLoader = stopWordsLoader;
        this.isValidWordPattern = Pattern.compile("[A-Za-z]+");
    }

    public long countWords(String text) {
        Objects.requireNonNull(text, "Text input must not be null");

        return Arrays.stream(text.trim().split("\\s+"))
                .filter(this::isWordValid)
                .filter(this::filterStopWords)
                .count();
    }

    private boolean isWordValid(String word) {
        return isValidWordPattern.matcher(word).matches();
    }

    private boolean filterStopWords(String w) {
        return !stopWordsLoader.containsWord(w);
    }
}
