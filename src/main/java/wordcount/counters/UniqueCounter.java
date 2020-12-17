package wordcount.counters;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UniqueCounter implements Counter {
    @Override
    public int countWords(Collection<String> input) {
        Set<String> uniqueWords = new HashSet<>(input);
        return uniqueWords.contains("") ? uniqueWords.size() - 1 : uniqueWords.size();
    }
}
