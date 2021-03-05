package at.erste.words;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    @Test
    void testOnlyFirstLineIsRead() {
        String initialString = "firstLine\nsecondLine";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        System.setIn(targetStream);
        assertEquals("firstLine", new InputReader().getInput());
    }
}