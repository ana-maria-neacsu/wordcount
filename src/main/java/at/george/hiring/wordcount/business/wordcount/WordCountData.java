package at.george.hiring.wordcount.business.wordcount;

import java.math.BigDecimal;

public class WordCountData {

    private final long wordCount;
    private final long uniqueWords;
    private final BigDecimal averageWordLength;

    public WordCountData(long wordCount, long uniqueWords, BigDecimal averageWordLength) {
        this.wordCount = wordCount;
        this.uniqueWords = uniqueWords;
        this.averageWordLength = averageWordLength;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getUniqueWords() {
        return uniqueWords;
    }

    public BigDecimal getAverageWordLength() {
        return averageWordLength;
    }
}
