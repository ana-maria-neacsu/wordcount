package wordcount.contract.business;

import java.util.List;

public interface StopWords {
    List<String> loadStopWordsFromClassPath();
}
