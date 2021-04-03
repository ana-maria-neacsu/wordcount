package at.george.wordcount;

import java.math.BigDecimal;
import java.util.TreeSet;

public class WordCountResult {
    private final long numWords;
    private final long numUniqueWords;
    private final BigDecimal avgWordLength;
    private final TreeSet<String> sortedWords;

    public WordCountResult(long numWords, long numUniqueWords, BigDecimal avgWordLength, TreeSet<String> sortedWords) {
        this.numWords = numWords;
        this.numUniqueWords = numUniqueWords;
        this.avgWordLength = avgWordLength;
        this.sortedWords = sortedWords;
    }

    public long getNumWords() {
        return numWords;
    }

    public long getNumUniqueWords() {
        return numUniqueWords;
    }

    public BigDecimal getAvgWordLength() {
        return avgWordLength;
    }

    public TreeSet<String> getSortedWords() {
        return sortedWords;
    }
}
