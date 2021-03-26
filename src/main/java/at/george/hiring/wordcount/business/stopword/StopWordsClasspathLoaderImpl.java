package at.george.hiring.wordcount.business.stopword;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StopWordsClasspathLoaderImpl implements StopWordsLoader {

    private final List<String> stopwords;

    public StopWordsClasspathLoaderImpl() {
        List<String> tmpStopwords = null;
        try {
            tmpStopwords = Files
                    .lines(Paths.get(getClass().getResource("/stopwords.txt").toURI()))
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            System.err.println("Unable to load stopwords file 'stopwords.txt' from classpath. Will assume 0 stopwords!");
        } finally {
            this.stopwords = (tmpStopwords != null) ? tmpStopwords : Collections.emptyList();
        }
    }

    @Override
    public boolean containsWord(String word) {
        return stopwords.contains(word);
    }
}
