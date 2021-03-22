package wordcount.interview.ui.output;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.OutputStream;
import java.io.PrintStream;

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
    void shouldWriteToOutput(String text) {
        sut.write(text);

        assertEquals(text, printStream.getLastText());
    }

    private class PrintStreamMock extends PrintStream {
        private String lastText;

        public PrintStreamMock(OutputStream out) {
            super(out);
        }

        @Override
        public void println(String text) {
            lastText = text;
        }

        public String getLastText() {
            return lastText;
        }
    }
}