package wordcounter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import wordcounter.exceptions.FileInputProviderException;

public class FileInputProvider implements InputProvider {

    private final String filename;

    public FileInputProvider(String filename) {
        this.filename = filename;
    }

    @Override
    public String getInput() {
        try {
            Path inputFile = Paths.get(filename);
            return Files.lines(inputFile).collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new FileInputProviderException("Unable to read input file.", e);
        }
    }
}
