package at.george.hiring.wordcount.input;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileInputSourceImplTest {

    @Test
    void GIVEN_anInputFile_WHEN_getText_THAN_returnFileContents() throws URISyntaxException, IOException {
        String expectedText = Files
                .lines(Paths.get(getClass().getResource("/testInputFile.txt").toURI()))
                .collect(Collectors.joining(" "));
        FileInputSourceImpl fileInputSource = new FileInputSourceImpl("src/test/resources/testInputFile.txt");
        String actualText = fileInputSource.getText();
        assertEquals(expectedText, actualText);
    }

    @Test
    void GIVEN_nonExistingInputFile_WHEN_getText_THAN_throwRuntimeException() {
        assertThrows(RuntimeException.class, () -> new FileInputSourceImpl("/non-existing-file.txt"));
    }

}