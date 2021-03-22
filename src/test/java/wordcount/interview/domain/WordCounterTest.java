package wordcount.interview.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WordCounterTest {
    private WordCounter sut;

    @BeforeEach
    void setUp() {
        sut = new WordCounter();
    }

    @ParameterizedTest
    @CsvSource({
            "word, 1",
            "world world, 2",
            "word word                word, 3",
            "F$$oo Ba3 Baz, 1"
    })
    void shouldCountWords(String text, int expectedOutcome) {
        long count = sut.count(text);

        assertEquals(expectedOutcome, count);
    }

    @Test
    void shouldCountWordsWithCommaInIt() {
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