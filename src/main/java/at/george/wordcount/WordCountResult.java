package at.george.wordcount;

import java.math.BigDecimal;

public class WordCountResult {
    private final long numWords;
    private final long numUniqueWords;
    private final BigDecimal avgWordLength;

    public WordCountResult(long numWords, long numUniqueWords, BigDecimal avgWordLength) {
        this.numWords = numWords;
        this.numUniqueWords = numUniqueWords;
        this.avgWordLength = avgWordLength;
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
}
