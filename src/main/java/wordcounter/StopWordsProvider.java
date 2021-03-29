package wordcounter;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import wordcounter.exceptions.StopWordsProviderException;

import static java.util.stream.Collectors.toCollection;

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
            Path path = getPathForFilename(filename);
            return Files.lines(path).collect(toCollection(HashSet::new));
        } catch (Exception e) {
            throw new StopWordsProviderException("Unable to read stop words.", e);
        }
    }

    /**
     * NullPointerException in thrown in case a resource file couldn't be found
     */
    private Path getPathForFilename(String filename) throws URISyntaxException {
        URL fileUrl = this.getClass().getClassLoader().getResource(filename);
        return Paths.get(fileUrl.toURI());
    }
}
