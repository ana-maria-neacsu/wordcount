package at.george.hiring.wordcount.business.wordcount;

public class WordCountData {

    private final long wordCount;
    private final long uniqueWords;

    public WordCountData(long wordCount, long uniqueWords) {
        this.wordCount = wordCount;
        this.uniqueWords = uniqueWords;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getUniqueWords() {
        return uniqueWords;
    }
}
