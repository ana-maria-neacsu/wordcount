package wordcount.counters;

import java.util.Collection;

public class WordCounter implements Counter {

    @Override
    public int countWords(Collection<String> input) {
        int count = 0;
        for (String w : input) {
            if (w.length() != 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int countUniques(Collection<String> input) {
        // TODO: implement
        throw new UnsupportedOperationException();
    }
}


