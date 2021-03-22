package wordcount.interview.ui.output;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import wordcount.interview.mock.PrintStreamMock;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ConsoleOutputTest {
    private PrintStreamMock printStream;
    private ConsoleOutput sut;

    @BeforeEach
    void setUp() {
        printStream = new PrintStreamMock(System.out);
        sut = new ConsoleOutput(printStream);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "text", "Enter text:", "Number of words:"})
    @NullAndEmptySource
    void shouldWriteOneTextToOutput(String text) {
        sut.write(text);

        assertEquals(1, printStream.getOutputTexts().size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "text", "Enter text:", "Number of words:"})
    @NullAndEmptySource
    void shouldWriteToOutput(String text) {
        sut.write(text);

        assertEquals(text, printStream.getOutputTexts().get(0));
    }
}