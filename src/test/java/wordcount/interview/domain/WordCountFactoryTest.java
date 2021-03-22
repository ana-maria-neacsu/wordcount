package wordcount.interview.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static wordcount.interview.domain.WordCountType.DEFAULT;
import static wordcount.interview.domain.WordCountType.WITH_ASK;

class WordCountFactoryTest {

    @Test
    void shouldBuildWordCountDefault() {
        WordCount wordCount = WordCountFactory.build(null, null, null, DEFAULT);

        assertEquals(wordCount.getClass(), WordCountDefault.class);
    }

    @Test
    void shouldBuildWordCountWithAsk() {
        WordCount wordCount = WordCountFactory.build(null, null, null, WITH_ASK);

        assertEquals(wordCount.getClass(), WordCountWithAsk.class);
    }
}