package at.george.hiring.wordcount.business.stopword;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StopWordsClasspathLoaderImpl implements StopWordsLoader {

    @Override
    public List<String> loadStopWords() {
        try {
            return Files
                    .lines(Paths.get(getClass().getResource("/stopwords.txt").toURI()))
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Unable to stopwords file 'stopwords.txt'", e);
        }
    }
}
