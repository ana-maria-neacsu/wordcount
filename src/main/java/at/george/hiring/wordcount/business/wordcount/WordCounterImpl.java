package at.george.hiring.wordcount.business.wordcount;

import at.george.hiring.wordcount.business.stopword.StopWordsLoader;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounterImpl implements WordCounter {

    private final StopWordsLoader stopWordsLoader;
    private final Pattern isValidWordPattern;

    public WordCounterImpl(StopWordsLoader stopWordsLoader) {
        this.stopWordsLoader = stopWordsLoader;
        this.isValidWordPattern = Pattern.compile("[A-Za-z]+");
    }

    public WordCountData countWords(String text) {
        Objects.requireNonNull(text, "Text input must not be null");

        List<String> allWords = Arrays.stream(text.trim().split("[\\s|\\-]+"))
                .map(this::removeDotOnWordEnd)
                .filter(this::isWordValid)
                .filter(this::filterStopWords)
                .collect(Collectors.toList());

        long uniqueWords = allWords.stream()
                .distinct()
                .count();

        return new WordCountData(allWords.size(), uniqueWords);
    }

    private String removeDotOnWordEnd(String w) {
        return (w.charAt(w.length() - 1) == '.') ? w.substring(0, w.length() - 1) : w;
    }

    private boolean isWordValid(String word) {
        return isValidWordPattern.matcher(word).matches();
    }

    private boolean filterStopWords(String w) {
        return !stopWordsLoader.containsWord(w);
    }
}
