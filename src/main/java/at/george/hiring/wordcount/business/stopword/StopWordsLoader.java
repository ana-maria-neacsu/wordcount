package at.george.hiring.wordcount.business.stopword;

import java.util.List;

public interface StopWordsLoader {
    List<String> loadStopWords();
}
