package wordcount.service;

import wordcount.contract.StopWords;
import wordcount.output.ConsoleOutputWriter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StopWordsLoader implements StopWords {
    @Override
    public List<String> loadStopWordsFromClassPath() {
        try {
            URL resource = getClass().getClassLoader()
                    .getResource("stopwords.txt");
            if (Objects.isNull(resource)) {
                return Collections.emptyList();
            }
            return Files.lines(Paths.get(resource.toURI())).collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            new ConsoleOutputWriter().write("Could not load stop words");
            return Collections.emptyList();
        }
    }
}
