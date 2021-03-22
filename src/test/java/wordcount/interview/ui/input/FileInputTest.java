package wordcount.interview.ui.input;

import org.junit.jupiter.api.Test;
import wordcount.interview.mock.FileLinesReaderMock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileInputTest {
    private static final String EXPECTED_FILE_NAME = "expectedFileName";
    private static final List<String> STUB_LINES = new ArrayList<>();
    private static final String EXPECTED_FILE_CONTENT = "Mary had\na little\nlamb";

    static {
        STUB_LINES.add("Mary had");
        STUB_LINES.add("a little");
        STUB_LINES.add("lamb");
    }

    @Test
    void shouldReturnConcatenatedStringFromFileLines() {
        FileInput sut = createSutWithStubbedLines(STUB_LINES);

        String result = sut.read();

        assertEquals(EXPECTED_FILE_CONTENT, result);
    }

    private FileInput createSutWithStubbedLines(List<String> lines) {
        return new FileInput(EXPECTED_FILE_NAME, new FileLinesReaderMock(lines, EXPECTED_FILE_NAME));
    }
}