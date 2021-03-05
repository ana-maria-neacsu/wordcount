package at.erste.words.input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputReaderFromStdInTest {

    @Test
    public void testOnlyFirstLineIsRead() {
        String initialString = "firstLine\nsecondLine";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        System.setIn(targetStream);
        assertEquals("firstLine", new InputReaderFromStdIn(System.out).getInput());
    }
}