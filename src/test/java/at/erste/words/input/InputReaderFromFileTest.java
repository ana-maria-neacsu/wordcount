package at.erste.words.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputReaderFromFileTest {

    @Test
    public void testReadFromFile() {
        String input = new InputReaderFromFile("mytext.txt").getInput();
        assertEquals("Mary had\n" +
                "a little\n" +
                "lamb\n", input);
    }

    @Test
    public void testNonExistingFile() {
        assertThrows(IllegalArgumentException.class, () -> {
            new InputReaderFromFile("fileWhichDoesNotExits.txt").getInput();
        });
    }
}