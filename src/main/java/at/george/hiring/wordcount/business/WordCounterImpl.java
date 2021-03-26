package at.george.hiring.wordcount.business;

import java.util.Arrays;
import java.util.Objects;

public class WordCounterImpl implements WordCounter {

    public long countWords(String text) {
        Objects.requireNonNull(text, "Text input must not be null");

        if (text.trim().isEmpty()) {
            return 0L;
        } else {
            return Arrays.stream(text.trim().split("\\s+"))
                    .filter(WordCounterImpl::isWordValid)
                    .count();
        }
    }

    private static boolean isWordValid(String word) {
        return word.matches("[A-Za-z]+");
    }
}
