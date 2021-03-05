package at.erste.words;

import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern pattern = Pattern.compile("[a-zA-Z]+");

    private StopWords stopWords;

    public WordCounter(final StopWords stopWords) {
        if (stopWords == null) {
            throw new IllegalArgumentException("Stopword cannot be null");
        }
        this.stopWords = stopWords;
    }

    public int count(final String input) {
        int count = 0;

        String[] strings = input.split("\\s+");
        for (String word : strings) {

            if (stopWords.getStopWords().contains(word)) {
                continue;
            }

            if (pattern.matcher(word).matches()) {
                count++;
            }
        }
        return count;
    }
}
