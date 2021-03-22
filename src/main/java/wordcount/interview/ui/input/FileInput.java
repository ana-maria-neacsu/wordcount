package wordcount.interview.ui.input;

import wordcount.interview.environment.file.FileLinesReader;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class FileInput implements Input {
    private final String fileName;
    private final FileLinesReader fileLinesReader;

    public FileInput(String fileName, FileLinesReader fileLinesReader) {
        this.fileName = fileName;
        this.fileLinesReader = fileLinesReader;
    }

    @Override
    public String read() {
        List<String> lines = fileLinesReader.getLines(fileName);
        return lines.stream()
                .collect(joining("\n"));
    }
}
