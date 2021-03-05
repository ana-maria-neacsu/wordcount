package at.erste.words;

import at.erste.words.ouput.WordCounterResult;
import at.erste.words.stopwords.StopWords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class WordCounter {

    // this regex matches white spaces, '.', '?', '!', '#' and '-'
    public static final String PARSING_REGEX = "[\\s-\\.!?#]+";
    private static final Pattern pattern = Pattern.compile("[a-zA-Z]+");
    private final Optional<StopWords> stopWords;

    public WordCounter(Optional<StopWords> stopWords) {
        this.stopWords = stopWords;
    }

    public WordCounterResult calculateResult(final String input) {
        List<String> words = new ArrayList<>();

        for (String word : input.split(PARSING_REGEX)) {

            if (isStopWord(word)) {
                continue;
            }
            if (pattern.matcher(word).matches()) {
                words.add(word);
            }
        }
        return new WordCounterResult(words.size(), new HashSet<>(words).size());
    }

    private boolean isStopWord(final String word) {
        return stopWords.isPresent()
                &&
                stopWords.get().getStopWords().contains(word);
    }
}
