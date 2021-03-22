package wordcount.interview.environment.file;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class FileLinesReaderTest {
    private static final String TEST_FILE_PATH = "src/test/resources/testFile.txt";
    private static final String INVALID_FILE_PATH = "invalid_path";
    private static final List<String> EXPECTED_LINES = new ArrayList<>();

    static {
        EXPECTED_LINES.add("the");
        EXPECTED_LINES.add("a");
        EXPECTED_LINES.add("on");
        EXPECTED_LINES.add("off");
    }

    private FileLinesReader sut;

    @BeforeEach
    void setUp() {
        sut = new FileLinesReader();
    }

    @Test
    void shouldReturnAllLinesInFile() {
        List<String> lines = sut.getLines(TEST_FILE_PATH);

        assertEquals(EXPECTED_LINES, lines);
    }

    @Test
    void shouldThrowNoSuchFileExceptionIfFileDoesNotExist() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> sut.getLines(INVALID_FILE_PATH));

        assertEquals(NoSuchFileException.class, runtimeException.getCause().getClass());
    }
}