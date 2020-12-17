package wordcount.counters;

import wordcount.readers.Reader;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StopWordCounter implements Counter {

    private Set<String> stopWords;

    public StopWordCounter(Collection<String> stopWords) {
        this.stopWords = new HashSet<>(stopWords);
    }

    public StopWordCounter(Reader stopWordsReader) {
        this.stopWords = new HashSet<>(stopWordsReader.read());
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

    @Override
    public int countUniques(Collection<String> input) {
        Set<String> uniqueWords = new HashSet<>(input);
        uniqueWords.removeAll(stopWords);
        return uniqueWords.contains("") ? uniqueWords.size() - 1 : uniqueWords.size();
    }
}
