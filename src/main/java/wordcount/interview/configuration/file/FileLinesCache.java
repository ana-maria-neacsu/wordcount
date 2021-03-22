package wordcount.interview.configuration.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.nio.file.Files.readAllLines;

public class FileLinesCache {
    private final Set<String> lines;

    public FileLinesCache(String name) {
        this.lines = getLInes(name);
    }

    public Set<String> getLines() {
        return lines;
    }

    private static Set<String> getLInes(String name) {
        Path path = Paths.get(name);
        List<String> lines = readLines(path, name);
        return new HashSet<>(lines);
    }

    private static List<String> readLines(Path path, String name) {
        try {
            return readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Could not getLines the file: [%s]", name), e);
        }
    }
}
