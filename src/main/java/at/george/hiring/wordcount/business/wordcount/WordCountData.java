package at.george.hiring.wordcount.business.wordcount;

public class WordCountData {

    final long wordCount;
    final long uniqueWords;

    public WordCountData(long wordCount, long uniqueWords) {
        this.wordCount = wordCount;
        this.uniqueWords = uniqueWords;
    }
}
