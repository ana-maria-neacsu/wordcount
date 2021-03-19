package wordcount.input;

import wordcount.contract.input.InputReader;
import wordcount.output.ConsoleOutputWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileInputReader implements InputReader {
    private String pathToFile;

    public FileInputReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }
    @Override
    public String readInput() {
        try {
            return Files.lines(Paths.get(pathToFile)).collect(Collectors.joining( " "));
        } catch (IOException e) {
            new ConsoleOutputWriter().write("Could not read file specified at: " + pathToFile);
        }
        return "";
    }
}
