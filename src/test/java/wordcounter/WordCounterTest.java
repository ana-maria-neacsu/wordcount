package wordcounter;

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
    public void should_return_1_for_regular_word() {
        assertEquals(1, wordCounter.count("word"));
    }

    @Test
    public void should_return_2_for_2_regular_words() {
        assertEquals(2, wordCounter.count("word word"));
    }

    @Test
    public void should_return_0_for_a_number() {
        assertEquals(0, wordCounter.count("123"));
    }

    @Test
    public void should_return_0_for_a_special_character() {
        assertEquals(0, wordCounter.count("!"));
    }

    @Test
    public void should_return_0_for_a_word_containing_special_character() {
        assertEquals(0, wordCounter.count("he!!o"));
    }

    @Test
    public void should_return_0_for_a_word_containing_number() {
        assertEquals(0, wordCounter.count("he11o"));
    }

    @Test
    public void should_return_1_for_a_regular_word_and_two_irregular_ones() {
        assertEquals(1, wordCounter.count("Hi he11o, Dav!d"));
    }

}
