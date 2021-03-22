package wordcount.interview.domain.stop;

import java.util.Set;

public interface StopWordsProvider {
    Set<String> get();
}