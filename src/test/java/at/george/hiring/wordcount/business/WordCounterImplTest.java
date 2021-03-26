package at.george.hiring.wordcount.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordCounterImplTest {

    static Stream<Arguments> produceTestData() {
        return Stream.of(
                arguments("Mary had a little lamb", 5L),
                arguments("", 0L),
                arguments("Foo44bar", 0L)
        );
    }

    @ParameterizedTest
    @MethodSource("produceTestData")
    void GIVEN_aSentence_WHEN_countWords_THEN_returnNumberOfWords(String text, long expectedWordCount) {
        Assertions.assertEquals(expectedWordCount, new WordCounterImpl().countWords(text), "Counting is wrong");
    }

    @Test
    void GIVEN_null_WHEN_countWords_THEN_throwNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> new WordCounterImpl().countWords(null));
    }

}