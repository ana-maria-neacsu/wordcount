package george.wordcount.logic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {
    private static final String WORD_SPLIT_REGEX = "\\s+";
    private static final String VALID_WORD_REGEX = "[a-zA-Z]+";
    private final List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public int countWordsOf(final String input) {
        final List<String> potentialWords = validateAndSplitIntoPotentialWords(input);
        final List<String> actualWords = validatePotentialWords(potentialWords);

        return actualWords.size();
    }

    private List<String> validateAndSplitIntoPotentialWords(String input) {
        if (input == null) {
            return new LinkedList<>();
        }

        return Arrays.asList(input.split(WORD_SPLIT_REGEX));
    }

    private List<String> validatePotentialWords(final List<String> potentialWords) {
        return potentialWords.stream()
                .filter(this::isValidWordUsingOnlyLetters)
                .filter(this::isNotAStopWord)
                .collect(Collectors.toList());
    }

    private boolean isNotAStopWord(final String input) {
        return !stopWords.contains(input);
    }

    private boolean isValidWordUsingOnlyLetters(final String input) {
        return input.matches(VALID_WORD_REGEX);
    }
}
