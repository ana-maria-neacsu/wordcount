package wordcount.interview.mock;

import wordcount.interview.domain.counter.WordCounter;

import static java.util.Collections.emptySet;

public class WordCounterMock extends WordCounter {
    private final long expectedCount;
    private String textToCount;

    public WordCounterMock(long expectedCount) {
        super(emptySet());
        this.expectedCount = expectedCount;
    }

    @Override
    public long count(String text) {
        textToCount = text;
        return expectedCount;
    }

    public String getTextToCount() {
        return textToCount;
    }
}
