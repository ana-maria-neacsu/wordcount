package at.george.wordcount;

public class WordCountResult {
    private final long numWords;
    private final long numUniqueWords;

    public WordCountResult(long numWords, long numUniqueWords) {
        this.numWords = numWords;
        this.numUniqueWords = numUniqueWords;
    }

    public long getNumWords() {
        return numWords;
    }

    public long getNumUniqueWords() {
        return numUniqueWords;
    }
}
