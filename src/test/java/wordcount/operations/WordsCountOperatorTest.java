package wordcount.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WordsCountOperatorTest {

    TextOperator textOperator = new WordsCountOperator();

    static Stream<Arguments> positiveTestDataProvider() {
        return Stream.of(
                arguments("Word word word", 3L),
                arguments("not so long but long enough", 6L),
                arguments("Only", 1L)
        );
    }

    static Stream<Arguments> negativeTestDataProviderWithNumbers() {
        return Stream.of(
                arguments("121Word", 0L),
                arguments("Wo121", 0L),
                arguments("121", 0L)
        );
    }
    static Stream<Arguments> negativeTestDataProviderWithSpecialCharacters() {
        return Stream.of(
                arguments("w@", 0L),
                arguments("!!@@@", 0L),
                arguments("ääs__--s", 0L)
        );
    }


    @ParameterizedTest
    @MethodSource("positiveTestDataProvider")
    public void assertForPositiveUseCases(String input, long expectedCount){
        Assertions.assertEquals(expectedCount, textOperator.operate(input));
    }


    @ParameterizedTest
    @MethodSource("negativeTestDataProviderWithNumbers")
    public void assertForNegativeTestCasesForNumbers(String input, long expectedCount){
        Assertions.assertEquals(expectedCount, textOperator.operate(input));
    }

    @ParameterizedTest
    @MethodSource("negativeTestDataProviderWithSpecialCharacters")
    public void assertForNegativeTestCasesForSpecialCharacters(String input, long expectedCount){
        Assertions.assertEquals(expectedCount, textOperator.operate(input));
    }

}
