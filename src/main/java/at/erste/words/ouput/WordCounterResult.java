package at.erste.words.ouput;

import java.io.PrintStream;

public class WordCounterResult {
    private final int count;
    private final int uniqueWordsCount;

    public WordCounterResult(int count, int uniqueWordsCount) {
        this.count = count;
        this.uniqueWordsCount = uniqueWordsCount;
    }

    public int getCount() {
        return count;
    }

    public int getUniqueWordsCount() {
        return uniqueWordsCount;
    }

    public void printResult(PrintStream outputStream) {
        outputStream.println("Number of words: " + count + ", unique: " + uniqueWordsCount);
    }
}
