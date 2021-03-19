package wordcount.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WordsCounterServiceTest {

    WordsCounterService wordsCounterService = new WordsCounterService(new StopWordsLoader());

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

    static Stream<Arguments> stopWordsTestDataProvider() {
        return Stream.of(
                arguments("Word is a word", 3L),
                arguments("THE day is the opposite of the night", 6L),
                arguments("On and off is not on", 4L),
                arguments("OFF is different from off", 4L)
        );
    }


    @ParameterizedTest
    @MethodSource("positiveTestDataProvider")
    public void assertForPositiveUseCases(String input, long expectedCount){
        Assertions.assertEquals(expectedCount, wordsCounterService.countWords(input));
    }


    @ParameterizedTest
    @MethodSource("negativeTestDataProviderWithNumbers")
    public void assertForNegativeTestCasesForNumbers(String input, long expectedCount){
        Assertions.assertEquals(expectedCount, wordsCounterService.countWords(input));
    }

    @ParameterizedTest
    @MethodSource("negativeTestDataProviderWithSpecialCharacters")
    public void assertForNegativeTestCasesForSpecialCharacters(String input, long expectedCount){
        Assertions.assertEquals(expectedCount, wordsCounterService.countWords(input));
    }

    @ParameterizedTest
    @MethodSource("stopWordsTestDataProvider")
    public void assertForStopWordsTestDataProvider(String input, long expectedCount){
        Assertions.assertEquals(expectedCount, wordsCounterService.countWords(input));
    }
}
