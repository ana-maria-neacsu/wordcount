package at.george.hiring.wordcount.business.wordcount;

import at.george.hiring.wordcount.business.stopword.StopWordsLoader;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.math.RoundingMode.HALF_UP;

public class WordCounterImpl implements WordCounter {

    private final StopWordsLoader stopWordsLoader;
    private final Pattern isValidWordPattern;

    public WordCounterImpl(StopWordsLoader stopWordsLoader) {
        this.stopWordsLoader = stopWordsLoader;
        this.isValidWordPattern = Pattern.compile("[A-Za-z]+");
    }

    @Override
    public WordCountData countWords(String text) {
        Objects.requireNonNull(text, "Text input must not be null");

        List<String> allWords = Arrays.stream(text.trim().split("\\s|-{2,}"))
                .map(this::removeDotOnWordEnd)
                .map(this::removeHypens)
                .filter(this::isWordValid)
                .filter(this::filterStopWords)
                .collect(Collectors.toList());

        int totalWordLength = allWords.stream()
                .mapToInt(String::length)
                .sum();

        long uniqueWords = allWords.stream()
                .distinct()
                .count();

        BigDecimal averageWordLength = new BigDecimal(totalWordLength).divide(new BigDecimal(allWords.size()), HALF_UP);
        return new WordCountData(allWords.size(), uniqueWords, averageWordLength);
    }

    private String removeDotOnWordEnd(String w) {
        return (!w.trim().isEmpty() && w.charAt(w.length() - 1) == '.') ? w.substring(0, w.length() - 1) : w;
    }

    private String removeHypens(String w) {
        return w.replaceAll("-", "");
    }

    private boolean isWordValid(String word) {
        return isValidWordPattern.matcher(word).matches();
    }

    private boolean filterStopWords(String w) {
        return !stopWordsLoader.containsWord(w);
    }
}
