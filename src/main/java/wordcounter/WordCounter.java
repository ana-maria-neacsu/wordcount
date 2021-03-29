package wordcounter;

import java.util.Objects;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class WordCounter {

    private static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+");
    public static final String EMPTY_SPACES = "\\s+";

    private final String text;

    /**
     *
     * This constructor returns accepts input text and the stopWords.
     *
     * @param text input text
     */
    public WordCounter(String text) {
        Objects.requireNonNull(text, "text must not be null");
        this.text = text;
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
        return WORD_PATTERN.matcher(word).matches();
    }
}
