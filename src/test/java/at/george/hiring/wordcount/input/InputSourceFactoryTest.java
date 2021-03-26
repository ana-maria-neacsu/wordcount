package at.george.hiring.wordcount.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputSourceFactoryTest {

    @Test
    void GIVEN_emptyArgument_WHEN_newInstance_THEN_returnConsoleInputSource() {
        InputSource actualInputSource = InputSourceFactory.newInstance(new String[0]);
        assertEquals(ConsoleInputSourceImpl.class, actualInputSource.getClass());
    }

    @Test
    void GIVEN_anArgument_WHEN_newInstance_THEN_returnFileInputSource() {
        InputSource actualInputSource = InputSourceFactory.newInstance(new String[]{"src/test/resources/testInputFile.txt"});
        assertEquals(FileInputSourceImpl.class, actualInputSource.getClass());
    }
}