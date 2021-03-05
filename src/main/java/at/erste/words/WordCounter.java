package at.erste.words;

import at.erste.words.stopwords.StopWords;

import java.util.Optional;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern pattern = Pattern.compile("[a-zA-Z]+");
    private final Optional<StopWords> stopWords;

    public WordCounter(Optional<StopWords> stopWords) {
        this.stopWords = stopWords;
    }

    public int count(final String input) {
        int count = 0;

        for (String word : input.split("\\s+")) {

            if (isStopWord(word)) {
                continue;
            }

            if (pattern.matcher(word).matches()) {
                count++;
            }
        }
        return count;
    }

    private boolean isStopWord(final String word) {
        return stopWords.isPresent()
                &&
                stopWords.get().getStopWords().contains(word);
    }
}
