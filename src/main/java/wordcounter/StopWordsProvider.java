package wordcounter;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import wordcounter.exceptions.StopWordsProviderException;

public class StopWordsProvider {

    private final String filename;

    /**
     * @param filename of the file containing stop words
     */
    public StopWordsProvider(String filename) {
        this.filename = filename;
    }

    public Set<String> getStopWords() {
        try {
            //read stop words from the file
            URL fileUrl = getUrlForFile(filename);
            Path path = Paths.get(fileUrl.toURI());
            Set<String> stopWords = Files.lines(path).collect(Collectors.toCollection(HashSet::new));
            return stopWords;
        } catch (Exception e) {
            throw new StopWordsProviderException("Unable to read stop words.", e);
        }
    }

    private URL getUrlForFile(String filename) {
        return this.getClass().getClassLoader().getResource(filename);
    }
}
