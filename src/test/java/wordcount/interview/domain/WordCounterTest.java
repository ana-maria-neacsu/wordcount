package wordcount.interview.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import wordcount.interview.domain.counter.WordCounter;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WordCounterTest {
    private static final String STOP_WORD_1 = "STOP";
    private static final String STOP_WORD_2 = "NO";
    private WordCounter sut;

    @BeforeEach
    void setUp() {
        Set<String> stopWords = new HashSet<>();
        stopWords.add(STOP_WORD_1);
        stopWords.add(STOP_WORD_2);

        sut = new WordCounter(stopWords);
    }

    @ParameterizedTest
    @CsvSource({
            "word, 1",
            "world world, 2",
            "word word                word, 3",
            "F$$oo Ba3 Baz, 1"
    })
    void shouldCountWordsWithoutStopWordsInIt(String text, int expectedOutcome) {
        long count = sut.count(text);

        assertEquals(expectedOutcome, count);
    }

    @ParameterizedTest
    @CsvSource({
            "word  STOP, 1",
            "world STOP world NO, 2"
    })
    void shouldCountWordsWithStopWordsInIt(String text, int expectedOutcome) {
        long count = sut.count(text);

        assertEquals(expectedOutcome, count);
    }

    @Test
    void shouldCountWordsWithoutStopWordsWithCommaInIt() {
        long count = sut.count("Foo, Bar. Baz!");

        assertEquals(0, count);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldCountZeroWordIfInputEmptyOrNull(String emptyText) {
        long count = sut.count(emptyText);

        assertEquals(0, count);
    }
}