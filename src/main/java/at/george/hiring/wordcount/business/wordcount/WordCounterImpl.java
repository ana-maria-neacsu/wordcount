package at.george.hiring.wordcount.business.wordcount;

import at.george.hiring.wordcount.business.stopword.StopWordsLoader;

import java.util.Arrays;
import java.util.Objects;

public class WordCounterImpl implements WordCounter {

    private StopWordsLoader stopWordsLoader;

    public WordCounterImpl(StopWordsLoader stopWordsLoader) {
        this.stopWordsLoader = stopWordsLoader;
    }

    public long countWords(String text) {
        Objects.requireNonNull(text, "Text input must not be null");

        if (text.trim().isEmpty()) {
            return 0L;
        } else {
            return Arrays.stream(text.trim().split("\\s+"))
                    .filter(WordCounterImpl::isWordValid)
                    .filter(this::filterStopWords)
                    .count();
        }
    }

    private static boolean isWordValid(String word) {
        return word.matches("[A-Za-z]+");
    }

    private boolean filterStopWords(String w) {
        return !stopWordsLoader.containsWord(w);
    }
}
