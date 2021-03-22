package wordcount.interview.mock;

import wordcount.interview.environment.file.FileLinesReader;

import java.util.List;

public class FileLinesReaderMock extends FileLinesReader {
    private final List<String> lines;
    private final String expectedFileName;

    public FileLinesReaderMock(List<String> lines, String expectedFileName) {
        this.lines = lines;
        this.expectedFileName = expectedFileName;
    }

    @Override
    public List<String> getLines(String fileName) {
        if (fileName.equals(expectedFileName)) {
            return lines;
        } else {
            return null;
        }
    }
}
