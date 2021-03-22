package wordcount.interview.domain.counter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Stream.of;

public class WordCounter {
    private static final String ONLY_LETTER_REGEXP = "[a-zA-Z]+";
    private static final String WHITESPACE = "\\s";
    private static final int ZERO = 0;

    private final Set<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = new HashSet<>(stopWords);
    }

    public long count(String text) {
        if (isBlank(text)) {
            return ZERO;
        }

        String[] words = split(text);
        return count(words);
    }

    private boolean isBlank(String text) {
        return text == null || text.length() == 0;
    }

    private String[] split(String text) {
        return text.split(WHITESPACE);
    }

    private long count(String[] words) {
        return of(words)
                .filter(this::isValid)
                .filter(this::isNotStopWord)
                .count();
    }

    private boolean isNotStopWord(String word) {
        return !stopWords.contains(word);
    }

    private boolean isValid(String word) {
        return word.matches(ONLY_LETTER_REGEXP);
    }
}
