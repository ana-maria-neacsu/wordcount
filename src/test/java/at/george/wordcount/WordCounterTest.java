package at.george.wordcount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    public static final String PATH_TO_STOPWORDS = "test_stopwords.txt";
    private WordCounter counter = new WordCounter();

    @ParameterizedTest
    @CsvSource({
            "'', 0",
            "word, 1",
            "word word, 2",
            "word1word word, 1",
            "'word word           wod', 3",
            "'. , 1 / *', 0",
            "'Foo1 Bar! Baz, Baz. word', 1",
            "' wordWithSpaceBefore', 1",
            "'wordWithSpaceAfter ', 1"
    })
    void count(final String text, final int expected) {
        int actual = counter.count(text);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "'', 0",
            "word, 1",
            "word word, 2",
            "word1word word, 1",
            "'word word           wod', 3",
            "'. , 1 / *', 0",
            "'Foo1 Bar! Baz, Baz. word', 1",
            "' wordWithSpaceBefore', 1",
            "'wordWithSpaceAfter ', 1",
            "the a word, 1",
    })
    void countWithStopWords(final String text, final int expected) {
        int actual = counter.count(text, PATH_TO_STOPWORDS);

        assertEquals(expected, actual);
    }
}