package at.george.hiring.wordcount.input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

public class FileInputSourceImpl implements InputSource{

    private final String text;

    public FileInputSourceImpl(String filename) {
        try {
            this.text = Files.lines(new File(filename).toPath()).collect(Collectors.joining(" "));
        } catch (IOException e) {
            throw new RuntimeException("File " + filename + " could not be loaded", e);
        }
    }

    @Override
    public String getText() {
        return text;
    }
}
