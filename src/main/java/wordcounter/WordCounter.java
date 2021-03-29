package wordcounter;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class WordCounter {

    private static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+");
    public static final String EMPTY_SPACES = "\\s+";

    private final String text;
    private final Set<String> stopWords;

    /**
     * Default value for stop words is taken - empty set
     * @param text input text
     */
    public WordCounter(String text) {
        this(text, Collections.emptySet());
    }

    /**
     *
     * This constructor accepts input text and the stop words (words to be skipped).
     *
     * @param text input text
     * @param stopWords list of words that are not counted
     */
    public WordCounter(String text, Set<String> stopWords) {
        Objects.requireNonNull(text, "text must not be null!");
        Objects.requireNonNull(stopWords, "stopWords must not be null!");
        this.text = text;
        this.stopWords = stopWords;
    }

    /**
     * This method returns the number of words found in a text.
     * Words are defined as stretches of letters (a-z,A-Z).
     * If a word belongs to a list with stop words, it won't be counted.
     *
     * @return count number of words found
     */
    public int count() {
        String[] words = text.split(EMPTY_SPACES);
        return countCorrectWords(words);
    }

    private int countCorrectWords(String[] words) {
        return stream(words)
                .filter(this::isCorrectWord)
                .mapToInt(w -> 1)
                .sum();
    }

    private boolean isCorrectWord(String word) {
        if (stopWords.contains(word)) {
            return false;
        }
        return WORD_PATTERN.matcher(word).matches();
    }
}
