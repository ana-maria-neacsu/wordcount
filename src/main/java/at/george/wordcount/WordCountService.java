package at.george.wordcount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCountService {

    public static final String WORD_DELIMITER = "[ ,\t\n]";
    private final Pattern wordPattern = Pattern.compile(".*[A-Za-z]+.*");
    private final Set<String> wordsExcluded;
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private final Optional<Set<String>> dictionary;

    public WordCountService(Set<String> wordsExcluded) {
        this(wordsExcluded, Collections.emptySet());
    }

    public WordCountService(Set<String> wordsExcluded, Set<String> dictionary) {
        this.wordsExcluded = Collections.unmodifiableSet(new HashSet<>(wordsExcluded));
        if (!dictionary.isEmpty()) {
            this.dictionary = Optional.of(Collections.unmodifiableSet(new HashSet<>(dictionary)));
        } else {
            this.dictionary = Optional.empty();
        }
    }

    public WordCountResult countWords(String text) {
        if (text == null || text.trim().length() == 0) {
            return new WordCountResult(0, 0, BigDecimal.ZERO, new TreeSet<>(), 0L);
        }
        return countWords(Arrays.stream(text.trim().split(WORD_DELIMITER)));
    }

    public WordCountResult countWords(Stream<String> words) {
        Objects.requireNonNull(words, "'words' may not be null!");

        Set<String> uniqueWords = new HashSet<>();
        AtomicLong wordLength = new AtomicLong(0); // Using AtomicLong for mutable long access
        AtomicLong numUnknown = new AtomicLong(0);
        long numWords = words
                .flatMap(line -> Arrays.stream(line.split(WORD_DELIMITER)))
                .filter(word -> wordPattern.matcher(word).matches())
                .filter(word -> !wordsExcluded.contains(word))
                .peek(uniqueWords::add)
                .peek(word -> wordLength.addAndGet(word.length()))
                .peek(word -> {
                    if (!this.isKnown(word)) {
                        numUnknown.incrementAndGet();
                    }
                })
                .count();

        BigDecimal avgWordLength = calculateAvgWordLength(wordLength, numWords);
        TreeSet<String> sortedWords = uniqueWords.stream().map(this::markUnknown).collect(Collectors.toCollection(TreeSet::new));
        return new WordCountResult(numWords, uniqueWords.size(), avgWordLength, sortedWords, numUnknown.get());
    }

    private BigDecimal calculateAvgWordLength(AtomicLong wordLength, long numWords) {
        BigDecimal avgWordLength;
        if (numWords == 0) {
            avgWordLength = new BigDecimal(0);
        } else {
            avgWordLength = new BigDecimal(wordLength.get()).divide(new BigDecimal(numWords), 2, RoundingMode.HALF_UP);
        }
        return avgWordLength;
    }

    protected String markUnknown(String word) {
        Objects.requireNonNull(word, "'word' must be supplied!");
        if (!this.dictionary.isPresent()) {
            return word;
        } else {
            if (this.isKnown(word)) {
                return word;
            } else {
                return word + "*";
            }
        }
    }

    protected boolean isKnown(String word) {
        Objects.requireNonNull(word, "'word' must be supplied!");
        return this.dictionary.map(strings -> strings.contains(word)).orElse(true);
    }
}
