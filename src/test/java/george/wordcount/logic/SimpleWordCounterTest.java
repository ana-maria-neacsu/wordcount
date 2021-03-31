package george.wordcount.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class SimpleWordCounterTest {
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
        // GIVEN:
        final SimpleWordCounter classUnderTest = new SimpleWordCounter(emptyList());

        // WHEN:
        final int result = classUnderTest.countWordsOf(input);

        // THEN:
        Assertions.assertEquals(expectedWordCount, result);
    }


    static Stream<Arguments> dataProviderFor_GIVEN_input_and_stopWords_WHEN_countWordsOf_is_called_THEN_stop_words_are_not_counted() {
        return Stream.of(
                Arguments.of(null, singletonList(""), 0),
                Arguments.of("", singletonList(""), 0),
                Arguments.of("a", asList("and", "then"), 1),
                Arguments.of("Hallo", asList("and", "then"), 1),
                Arguments.of("FooBar", asList("FooBar", "then"), 0),
                Arguments.of("BarFoo", asList("Foo", "Bar"), 1),
                Arguments.of("FooäBar", asList("Foo", "Bar"), 0),
                Arguments.of("Mary had a little lamb", asList("the", "a", "on", "off"), 4),
                Arguments.of("Mary had a little lamb", asList("lAmb", "Lamb"), 5)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderFor_GIVEN_input_and_stopWords_WHEN_countWordsOf_is_called_THEN_stop_words_are_not_counted")
    public void GIVEN_input_and_stopWords_WHEN_countWordsOf_is_called_THEN_stop_words_are_not_counted(
            final String input,
            final List<String> stopWords,
            final int expectedWordCount) {
        // GIVEN:
        final SimpleWordCounter classUnderTest = new SimpleWordCounter(stopWords);

        // WHEN:
        final int result = classUnderTest.countWordsOf(input);

        // THEN:
        Assertions.assertEquals(expectedWordCount, result);
    }
}
