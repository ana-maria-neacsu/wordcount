package at.george.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourceProvider {
    public Set<String> fetchStopWords() {
        try (InputStream stopwords = ResourceProvider.class.getResourceAsStream("/stopwords.txt")) {
            try (InputStreamReader isr = new InputStreamReader(stopwords)) {
                try (BufferedReader reader = new BufferedReader(isr)) {
                    return reader.lines().collect(Collectors.toSet());
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read 'stopwords.txt'!", e);
        }
    }
}
