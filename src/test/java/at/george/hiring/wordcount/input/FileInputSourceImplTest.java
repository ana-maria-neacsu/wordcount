package at.george.hiring.wordcount.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class FileInputSourceImplTest {

    @Test
    void GIVEN_anInputFile_WHEN_getText_THAN_returnFileContents() throws URISyntaxException, IOException {
        String expectedText = Files
                .lines(Paths.get(getClass().getResource("/testInputFile.txt").toURI()))
                .collect(Collectors.joining(" "));
        FileInputSourceImpl fileInputSource = new FileInputSourceImpl("src/test/resources/testInputFile.txt");
        String actualText = fileInputSource.getText();
        Assertions.assertEquals(expectedText, actualText );
    }

}