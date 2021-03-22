package wordcount.interview.configuration.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {
    private static final String TEST_FILE_PATH = "src/test/resources/testFile.txt";
    private static final String INVALID_FILE_PATH = "invalid_path";
    private static final Set<String> EXPECTED_LINES = new HashSet<>();

    static {
        EXPECTED_LINES.add("the");
        EXPECTED_LINES.add("a");
        EXPECTED_LINES.add("on");
        EXPECTED_LINES.add("off");
    }

    @Test
    void shouldReturnAllLinesInFile() {
        FileLinesCache sut = createSut(TEST_FILE_PATH);

        Set<String> lines = sut.getLines();

        assertEquals(EXPECTED_LINES, lines);
    }

    @Test
    void shouldFailFastIfFileDoesNotExist() {
        assertThrows(RuntimeException.class, () -> createSut(INVALID_FILE_PATH));
    }

    @Test
    void shouldHaveIOExceptionAsACause() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> createSut(INVALID_FILE_PATH));

        assertEquals(NoSuchFileException.class, runtimeException.getCause().getClass());
    }

    private FileLinesCache createSut(String fileName) {
        return new FileLinesCache(fileName);
    }
}