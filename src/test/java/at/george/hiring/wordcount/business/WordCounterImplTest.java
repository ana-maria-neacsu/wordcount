package at.george.hiring.wordcount.business;

import at.george.hiring.wordcount.business.stopword.StopWordsLoader;
import at.george.hiring.wordcount.business.wordcount.WordCounterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordCounterImplTest {

    static Stream<Arguments> produceTestData() {
        return Stream.of(
                arguments("Mary had a little lamb", 5L),
                arguments("", 0L),
                arguments("Foo44bar", 0L),
                arguments("Mary had a little lamb.", 4L),
                arguments("Mary and Tom, her little brother, had a little lamb.", 7L),
                arguments("Mary's lamb", 1L),
                arguments("Mary's lamb.", 0L),
                arguments("Mary   had  a     little lamb", 5L)
        );
    }

    private StopWordsLoader testStopWordsLoader;

    @BeforeEach
    void setup() {
        testStopWordsLoader = new TestStopWordLoader();
    }

    @ParameterizedTest
    @MethodSource("produceTestData")
    void GIVEN_aSentence_WHEN_countWords_THEN_returnNumberOfWords(String text, long expectedWordCount) {
        WordCounterImpl wordCounter = new WordCounterImpl(testStopWordsLoader);
        long actualWordCount = wordCounter.countWords(text);
        assertEquals(expectedWordCount, actualWordCount, "Counting is wrong");
    }

    @Test
    void GIVEN_null_WHEN_countWords_THEN_throwNullPointerException() {
        assertThrows(NullPointerException.class, () -> new WordCounterImpl(testStopWordsLoader).countWords(null));
    }

    static class TestStopWordLoader implements StopWordsLoader {
        @Override
        public boolean containsWord(String word) {
            return false;
        }
    }


}