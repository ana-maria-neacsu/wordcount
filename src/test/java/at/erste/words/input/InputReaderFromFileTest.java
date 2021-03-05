package at.erste.words.input;

import at.erste.words.input.InputReaderFromFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputReaderFromFileTest {

    @Test
    void testReadFromFile() {
        String input = new InputReaderFromFile("mytext.txt").getInput();
        assertEquals("Mary had\n" +
                "a little\n" +
                "lamb\n", input);
    }
}