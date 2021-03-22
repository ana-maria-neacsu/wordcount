package wordcount.interview.domain;

import static java.util.stream.Stream.of;

public class WordCounter {
    private static final String ONLY_LETTER_REGEXP = "[a-zA-Z]+";
    private static final String WHITESPACE = "\\s";

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
                .count();
    }

    private boolean isValid(String word) {
        return word.matches(ONLY_LETTER_REGEXP);
    }
}
