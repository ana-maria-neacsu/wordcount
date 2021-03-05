package at.erste.words;

import at.erste.words.input.StandardInputReader;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class StandardInputReaderTest {

    @Test
    void testOnlyFirstLineIsRead() {
        String initialString = "firstLine\nsecondLine";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        System.setIn(targetStream);
        assertEquals("firstLine", new StandardInputReader().getInput());
    }
}