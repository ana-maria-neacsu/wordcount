package at.george.wordcount;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordCountService {

    public static final String WORD_DELIMITER = "[ ,\t\n]";
    private final Pattern wordPattern = Pattern.compile(".*[A-Za-z]+.*");
    private final Set<String> wordsExcluded;

    public WordCountService(Set<String> wordsExcluded) {
        this.wordsExcluded = Collections.unmodifiableSet(new HashSet<>(wordsExcluded));
    }

    public WordCountResult countWords(String text) {
        if (text == null || text.trim().length() == 0) {
            return new WordCountResult(0, 0);
        }
        return countWords(Arrays.stream(text.trim().split(WORD_DELIMITER)));
    }

    public WordCountResult countWords(Stream<String> words) {
        Objects.requireNonNull(words, "'words' may not be null!");
        Set<String> uniqueWords = new HashSet<>();
        long numWords = words
                .flatMap(line -> Arrays.stream(line.split(WORD_DELIMITER)))
                .filter(word -> wordPattern.matcher(word).matches())
                .filter(word -> !wordsExcluded.contains(word))
                .peek(uniqueWords::add)
                .count();
        return new WordCountResult(numWords, uniqueWords.size());
    }
}
