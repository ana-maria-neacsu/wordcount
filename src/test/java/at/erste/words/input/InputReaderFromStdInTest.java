package at.erste.words.input;

import at.erste.words.input.InputReader;
import at.erste.words.input.InputReaderFromStdIn;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputReaderFromStdInTest {

    @Test
    void testOnlyFirstLineIsRead() {
        String initialString = "firstLine\nsecondLine";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        System.setIn(targetStream);
        assertEquals("firstLine", new InputReaderFromStdIn().getInput());
    }
}