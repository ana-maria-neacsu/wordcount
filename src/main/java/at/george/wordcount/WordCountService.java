package at.george.wordcount;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordCountService {

    public static final String WORD_DELIMITER = "[ ,\\-\t\n]";
    private final Pattern wordPattern = Pattern.compile(".*[A-Za-z]+.*");
    private final Set<String> wordsExcluded;

    public WordCountService(Set<String> wordsExcluded) {
        this.wordsExcluded = Collections.unmodifiableSet(new HashSet<>(wordsExcluded));
    }

    public long countWords(String text) {
        if (text == null || text.trim().length() == 0) {
            return 0;
        }
        return countWords(Arrays.stream(text.trim().split(WORD_DELIMITER)));
    }

    public long countWords(Stream<String> words) {
        Objects.requireNonNull(words, "'words' may not be null!");
        return words
                .flatMap(line -> Arrays.stream(line.split(WORD_DELIMITER)))
                .filter(word -> wordPattern.matcher(word).matches())
                .filter(word -> !wordsExcluded.contains(word))
                .count();
    }
}
