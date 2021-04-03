package at.george.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourceProvider {
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public Set<String> fetchStopWords() {
        return new HashSet<>(fetchFromFile("/stopwords.txt"));
    }

    public Set<String> fetchDictionary(String dictPath) {
        return new HashSet<>(fetchFromFile(dictPath));
    }

    public List<String> fetchFromFile(String filename) {
        Objects.requireNonNull(filename, "filename must be provided!");
        try (InputStream stopwords = ResourceProvider.class.getResourceAsStream(filename)) {
            try (InputStreamReader isr = new InputStreamReader(stopwords)) {
                try (BufferedReader reader = new BufferedReader(isr)) {
                    return reader.lines().collect(Collectors.toList());
                }
            }
        } catch (IOException | NullPointerException e) {
            throw new ResourceNotFoundException("Cannot read from filename '" + filename + "'!", e);
        }
    }
}
