package wordcount.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WordsCounterTest {

    TextOperator textOperator = new WordsCounter();

    static Stream<Arguments> positiveTestDataProvider() {
        return Stream.of(
                arguments("Word word word", 3L),
                arguments("not so long but long enough", 6L),
                arguments("Only", 1L)
        );
    }

    @ParameterizedTest
    @MethodSource("positiveTestDataProvider")
    public void assertForPositiveUsecases(String input, long expectedCount){
        Assertions.assertEquals(expectedCount, textOperator.operate(input));
    }
}
