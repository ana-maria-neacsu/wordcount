package george.wordcount.logic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class WordCountImpl implements WordCount {
    private static final String WORD_SPLIT_REGEX = "\\s+";
    private final WordValidator wordValidator;

    public WordCountImpl(WordValidator wordValidator) {
        this.wordValidator = wordValidator;
    }

    @Override
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
                .filter(wordValidator::isValidWord)
                .collect(Collectors.toList());
    }
}
