package wordcounter;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class WordCounter {

    private static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+");
    public static final String EMPTY_SPACES = "\\s+";

    /**
     * This method returns number of words found in a text.
     * Words are defined as stretches of letters (a-z,A-Z)
     * @param text input text
     * @return number of words found
     */
    public int count(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }

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
