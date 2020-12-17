package wordcount.counters;

import java.util.Collection;

public class StopWordCounter implements Counter {

    Collection<String> stopWords;

    public StopWordCounter(Collection<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public int countWords(Collection<String> input) {
        int count = 0;
        for (String w : input) {
            if (w.length() != 0 && !stopWords.contains(w)) {
                count++;
            }
        }
        return count;
    }
}
