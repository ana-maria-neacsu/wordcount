package wordcount.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileInputReaderTest {

    FileInputReader fileInputReader = new FileInputReader("C:\\Code\\wordcount\\src\\test\\resources\\mytext.txt");

    @Test
    public void fileInputToStringTest() {
        String fileContent = fileInputReader.readInput();
        Assertions.assertNotNull(fileContent);
        Assertions.assertEquals("Mary had a little lamb", fileContent);
    }
}
