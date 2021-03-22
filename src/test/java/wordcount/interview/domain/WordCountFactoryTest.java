package wordcount.interview.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static wordcount.interview.domain.WordCountType.DEFAULT;
import static wordcount.interview.domain.WordCountType.WITH_ASK;

class WordCountFactoryTest {

    @Test
    void shouldBuildWordCountDefault() {
        WordCount wordCount = build(DEFAULT);

        assertEquals(wordCount.getClass(), WordCountDefault.class);
    }

    @Test
    void shouldBuildWordCountWithAsk() {
        WordCount wordCount = build(WITH_ASK);

        assertEquals(wordCount.getClass(), WordCountWithAsk.class);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWithoutType() {
        assertThrows(IllegalArgumentException.class, () -> build(null));
    }

    private WordCount build(WordCountType type) {
        return WordCountFactory.build(null, null, null, type);
    }
}