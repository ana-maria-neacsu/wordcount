package george.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.nio.charset.StandardCharsets.UTF_8;

class ApplicationIntegrationTest {
    private final static String UTF_8_NAME = UTF_8.name();

    private static class TestableApplication extends Application {
        private final PrintStream printStream;
        private final InputStream inputStream;

        public TestableApplication(PrintStream printStream, InputStream inputStream) {
            this.printStream = printStream;
            this.inputStream = inputStream;
        }

        @Override
        protected PrintStream getPrintStream() {
            return this.printStream;
        }

        @Override
        protected InputStream getInputStream() {
            return this.inputStream;
        }
    }

    static Stream<Arguments> dataProviderFor_GIVEN_userInteractionFlow_started_WHEN_user_input_is_entered_THEN_output_is_as_expected() {
        return Stream.of(
                Arguments.of("" + lineSeparator(), null, "Enter text: Number of words: 0" + lineSeparator()),
                Arguments.of("Hallo" + lineSeparator(), null, "Enter text: Number of words: 1" + lineSeparator()),
                Arguments.of("FooäBar" + lineSeparator(), null, "Enter text: Number of words: 0" + lineSeparator()),
                Arguments.of(" This is test  " + lineSeparator(), null, "Enter text: Number of words: 3" + lineSeparator()),
                Arguments.of("Mary had a little lamb" + lineSeparator(), null, "Enter text: Number of words: 4" + lineSeparator())
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderFor_GIVEN_userInteractionFlow_started_WHEN_user_input_is_entered_THEN_output_is_as_expected")
    public void GIVEN_userInteractionFlow_started_WHEN_user_input_is_entered_THEN_output_is_as_expected(
            final String input,
            final String[] arguments,
            final String expectedOutput) throws IOException {
        // GIVEN:
        final ByteArrayOutputStream outputReceiver = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(outputReceiver, true, UTF_8_NAME);
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes(UTF_8));
        final Application classUnderTest = new TestableApplication(printStream, inputStream);

        // WHEN:
        classUnderTest.wireUpAndExecute(arguments);

        // THEN:
        String data = outputReceiver.toString(UTF_8_NAME);
        Assertions.assertEquals(expectedOutput, data);

        // CLEANUP:
        printStream.close();
    }
}