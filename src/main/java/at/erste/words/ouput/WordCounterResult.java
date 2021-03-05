package at.erste.words.ouput;

import java.io.PrintStream;

public class WordCounterResult {
    private final int count;
    private final int uniqueWordsCount;
    private final double averageSize;

    public WordCounterResult(int count, int uniqueWordsCount, double averageSize) {
        this.count = count;
        this.uniqueWordsCount = uniqueWordsCount;
        this.averageSize = averageSize;
    }

    public void printResult(PrintStream outputStream) {
        outputStream.println("Number of words: " + count +
                ", unique: " + uniqueWordsCount +
                ", average word length: " + averageSize);
    }

    public int getCount() {
        return count;
    }

    public int getUniqueWordsCount() {
        return uniqueWordsCount;
    }

    public double getAverageSize() {
        return averageSize;
    }
}
