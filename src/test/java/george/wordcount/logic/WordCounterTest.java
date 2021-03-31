package george.wordcount.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class WordCounterTest {
    final private WordCounter classUnderTest = new WordCounter();

    static Stream<Arguments> dataProviderFor_GIVEN_simple_input_WHEN_countWordsOf_is_called_THEN_result_is_as_expected() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 0),
                Arguments.of("a", 1),
                Arguments.of("z", 1),
                Arguments.of("Hallo", 1),
                Arguments.of("FooBar", 1),
                Arguments.of("FooBar", 1),
                Arguments.of("FooäBar", 0),
                Arguments.of(" Hallo", 1),
                Arguments.of("   Hallo", 1),
                Arguments.of("Hallo ", 1),
                Arguments.of("Hallo    ", 1),
                Arguments.of("    Hallo    ", 1),
                Arguments.of("Hello World", 2),
                Arguments.of(" This is test  ", 3),
                Arguments.of("Mary had a little lamb", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderFor_GIVEN_simple_input_WHEN_countWordsOf_is_called_THEN_result_is_as_expected")
    public void GIVEN_simple_input_WHEN_countWordsOf_is_called_THEN_result_is_as_expected(
            final String input,
            final int expectedWordCount) {
        // WHEN
        final int result = this.classUnderTest.countWordsOf(input);

        // THEN
        Assertions.assertEquals(expectedWordCount, result);
    }
}
