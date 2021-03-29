package wordcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {

    private WordCounter wordCounter;

    @BeforeEach
    public void initialize() {
        wordCounter = new WordCounter();
    }

    @Test
    public void should_throw_exception_when_null_is_provided() {
        assertThrows(IllegalArgumentException.class, () -> wordCounter.count(null));
    }

    @Test
    public void should_return_0_when_no_words() {
        int count = wordCounter.count("");
        assertEquals(0, count);
    }

    @Test
    public void should_return_1() {
        assertEquals(1, wordCounter.count("word"));
    }

    @Test
    public void should_return_2() {
        assertEquals(2, wordCounter.count("word word"));
    }

    @Test
    public void should_return_1_234() {
        assertEquals(1, wordCounter.count("word2 word"));
    }

}
