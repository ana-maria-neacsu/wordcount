package wordcount.contract;

import java.util.List;

public interface StopWords {
    List<String> loadStopWordsFromClassPath();
}
