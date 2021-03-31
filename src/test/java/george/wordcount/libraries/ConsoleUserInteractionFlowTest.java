package george.wordcount.libraries;

import george.wordcount.logic.WordCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Collections.emptyList;

class ConsoleUserInteractionFlowTest {
    private final static String UTF_8_NAME = UTF_8.name();

    static Stream<Arguments> dataProviderFor_WHEN_consoleUserInteractionFlow_is_used_THEN_input_and_output_are_correctly_used() {
        return Stream.of(
                Arguments.of("  Hello World !!", "Enter text: Number of words: 2" + lineSeparator()),
                Arguments.of("Mary had a little lamb", "Enter text: Number of words: 5" + lineSeparator())
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderFor_WHEN_consoleUserInteractionFlow_is_used_THEN_input_and_output_are_correctly_used")
    public void WHEN_consoleUserInteractionFlow_is_used_THEN_input_and_output_are_correctly_used(
            final String input,
            final String expectedOutput
    ) throws UnsupportedEncodingException {
        // GIVEN:
        final ByteArrayOutputStream outputReceiver = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outputReceiver, true, UTF_8_NAME);
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes(UTF_8));
        final ConsoleUserInteractionFlow classUnderTest = new ConsoleUserInteractionFlow(new WordCounter(emptyList()), printStream, inputStream);

        // WHEN:
        classUnderTest.doInteraction();

        // THEN:
        String data = outputReceiver.toString(UTF_8_NAME);
        Assertions.assertEquals(expectedOutput, data);

        // CLEANUP:
        printStream.close();
    }
}