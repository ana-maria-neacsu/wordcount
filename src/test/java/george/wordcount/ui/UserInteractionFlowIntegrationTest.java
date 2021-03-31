package george.wordcount.ui;

import george.wordcount.logic.MockWordCounter;
import george.wordcount.logic.WordCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

class UserInteractionFlowIntegrationTest {
    public class NoInteractionWordCounter implements WordCounter {
        @Override
        public int countWordsOf(String input) {
            Assertions.fail("unexpected invocation of WordCounter");
            return -1;
        }
    }

    private static class TestableUserInteractionFlow extends UserInteractionFlow {
        private final String testInput;
        private final List<String> testOutput;

        public TestableUserInteractionFlow(WordCounter wordCounter, String testInput, List<String> testOutput) {
            super(wordCounter);
            this.testInput = testInput;
            this.testOutput = testOutput;
        }

        @Override
        protected void printText(String text) {
            // collect all the output we print
            this.testOutput.add(text);
        }

        @Override
        protected String promptUserForString(String inputText) {
            return this.testInput;
        }
    }

    static Stream<Arguments> dataProviderFor_GIVEN_userInteractionFlow_started_WHEN_user_input_is_entered_THEN_output_is_as_expected() {
        return Stream.of(
                Arguments.of(" This is test  ", 3, "Number of words: 3"),
                Arguments.of("Mary had a little lamb", 4, "Number of words: 4")
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderFor_GIVEN_userInteractionFlow_started_WHEN_user_input_is_entered_THEN_output_is_as_expected")
    public void GIVEN_userInteractionFlow_started_WHEN_user_input_is_entered_THEN_output_is_as_expected(
            final String input,
            final int wordCount,
            final String expectedOutput) {
        // GIVEN:
        final LinkedList<String> output = new LinkedList<>();
        final WordCounter wordCounter = new MockWordCounter(input, wordCount);
        final UserInteractionFlow classUnderTest =
                new TestableUserInteractionFlow(wordCounter, input, output);

        // WHEN:
        classUnderTest.doInteraction(null);

        // THEN:
        Assertions.assertEquals(1, output.size(), "we only expect one output call");
        Assertions.assertEquals(expectedOutput, output.get(0));
    }

    @Test
    public void GIVEN_userInteractionFlow_with_empty_args_WHEN_user_input_is_entered_THEN_output_is_as_expected() {
        // GIVEN:
        final String input = "Mary had a little lamb";
        final LinkedList<String> output = new LinkedList<>();
        final WordCounter wordCounter = new MockWordCounter(input, 4);
        final UserInteractionFlow classUnderTest =
                new TestableUserInteractionFlow(wordCounter, input, output);

        // WHEN:
        classUnderTest.doInteraction(new String[]{});

        // THEN:
        Assertions.assertEquals(1, output.size(), "we only expect one output call");
        Assertions.assertEquals("Number of words: 4", output.get(0));
    }

    static Stream<Arguments> dataProviderFor_WHEN_userInteractionFlow_started_with_non_empty_args_THEN_input_is_read_from_file() {
        return Stream.of(
                Arguments.of((Object) new String[]{"a", "b"}),
                Arguments.of((Object) new String[]{"a", "b", "2"})
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderFor_WHEN_userInteractionFlow_started_with_non_empty_args_THEN_input_is_read_from_file")
    public void WHEN_userInteractionFlow_started_with_non_empty_args_THEN_we_get_an_error_message(
            final String[] arguments) {
        // GIVEN:
        final LinkedList<String> output = new LinkedList<>();
        final WordCounter wordCounter = new NoInteractionWordCounter();
        final UserInteractionFlow classUnderTest =
                new TestableUserInteractionFlow(wordCounter, "dummy", output);

        // WHEN:
        classUnderTest.doInteraction(arguments);

        // THEN:
        Assertions.assertEquals(1, output.size(), "we only expect one output call");
        Assertions.assertEquals("Either no or one command line argument is allowed", output.get(0));
    }

    @Test
    public void WHEN_userInteractionFlow_started_with_valid_file_argument_empty_args_THEN_we_get_an_error_message() {
        // GIVEN:
        final String expectedInput = "Mary had a little lamb";
        final LinkedList<String> output = new LinkedList<>();
        final WordCounter wordCounter = new MockWordCounter(expectedInput, 4);
        final UserInteractionFlow classUnderTest =
                new TestableUserInteractionFlow(wordCounter, "dummy", output);
        final String pathToTestFile =
                UserInteractionFlow.class.getClassLoader().getResource("testData.txt").getPath();

        // WHEN:
        classUnderTest.doInteraction(new String[]{ pathToTestFile });

        // THEN:
        Assertions.assertEquals(1, output.size(), "we only expect one output call");
        Assertions.assertEquals("Number of words: 4", output.get(0));
    }
}
