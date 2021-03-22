package wordcount.interview.domain;

import java.util.Set;

import static java.util.stream.Stream.of;

public class WordCounter {
    private static final String ONLY_LETTER_REGEXP = "[a-zA-Z]+";
    private static final String WHITESPACE = "\\s";

    private final Set<String> stopWords;

    public WordCounter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public long count(String text) {
        if (isBlank(text)) {
            return 0;
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
