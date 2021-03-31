package george.wordcount.libraries;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StopWordProvider {
    private static final String STOPWORDS_FILE_PATH = "stopwords.txt";

    public List<String> provide() throws URISyntaxException, IOException {
        final URL urlToResource =
                StopWordProvider.class.getClassLoader().getResource(STOPWORDS_FILE_PATH);
        final File resourceFile =
                new File(urlToResource.toURI());

        return Files.readAllLines(resourceFile.toPath(), UTF_8);
    }
}
