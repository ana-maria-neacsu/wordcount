package wordcount.counters;

import java.util.Collection;

public class StopWordCounter implements Counter {

    Collection<String> skipWords;

    public StopWordCounter(Collection<String> skipWords) {
        this.skipWords = skipWords;
    }

    @Override
    public int countWords(Collection<String> input) {
        int count = 0;
        for (String w : input) {
            if (w.length() != 0 && !skipWords.contains(w)) {
                count ++;
            }
        }
        return count;
    }
}
