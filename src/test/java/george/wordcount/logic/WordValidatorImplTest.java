package george.wordcount.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordValidatorImplTest {
    private final WordValidator classUnderTest = new WordValidatorImpl();

    static Stream<Arguments> dataProviderFor_testThatComponentBIsUsed() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of("", false),
                Arguments.of("a", true),
                Arguments.of("z", true),
                Arguments.of("Hallo", true),
                Arguments.of("FooBar", true),
                Arguments.of("FooBar", true),
                Arguments.of("FooäBar", false)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProviderFor_testThatComponentBIsUsed")
    public void GIVEN_simple_input_WHEN_countWordsOf_is_called_THEN_result_is_as_expected(
            final String input,
            final boolean expectedResult) {
        // WHEN
        final boolean result = this.classUnderTest.isValidWord(input);

        // THEN
        Assertions.assertEquals(expectedResult, result);
    }
}