package at.george.hiring.wordcount.business.wordcount;

import java.math.BigDecimal;
import java.util.Set;

public class WordCountData {

    private final long wordCount;
    private final long uniqueWords;
    private final BigDecimal averageWordLength;
    private final Set<String> uniqueWordSet;

    public WordCountData(long wordCount, long uniqueWords, BigDecimal averageWordLength, Set<String> uniqueWordsSet) {
        this.wordCount = wordCount;
        this.uniqueWords = uniqueWords;
        this.averageWordLength = averageWordLength;
        this.uniqueWordSet = uniqueWordsSet;
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

    public Set<String> getUniqueWordSet() {
        return uniqueWordSet;
    }
}
