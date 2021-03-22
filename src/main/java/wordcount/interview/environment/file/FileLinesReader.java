package wordcount.interview.environment.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class FileLinesReader {
    public List<String> getLines(String fileName) {
        Path path = Paths.get(fileName);
        List<String> lines = readLines(path, fileName);
        return lines;
    }

    private List<String> readLines(Path path, String name) {
        try {
            return readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Could not getLines the file: [%s]", name), e);
        }
    }
}
