package wordcount.interview.ui.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ConsoleInputTest {
    private static final String EMPTY = "";
    private static final String TERMINATED_EMPTY = "\n";

    @ParameterizedTest
    @ValueSource(strings = {"a", "test", "Word word", "!$%"})
    void shouldReadFromInputStream(String input) {
        ConsoleInput sut = createSut(input);

        String result = sut.read();

        assertEquals(input, result);
    }

    @Test
    void shouldReadEmpty() {
        ConsoleInput sut = createSut(TERMINATED_EMPTY);

        String result = sut.read();

        assertEquals(result, EMPTY);
    }

    private ConsoleInput createSut(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        return new ConsoleInput(inputStream);
    }
}