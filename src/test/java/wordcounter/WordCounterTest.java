package wordcounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {

    @Test
    public void should_throw_exception_when_null_is_provided() {
        assertThrows(NullPointerException.class, () -> createWordCounterWith(null));
    }

    @Test
    public void should_return_0_when_no_words() {
        int count = createWordCounterWith("").count();
        assertEquals(0, count);
    }

    @Test
    public void should_return_1_for_regular_word() {
        assertEquals(1, createWordCounterWith("word").count());
    }

    @Test
    public void should_return_2_for_2_regular_words() {
        assertEquals(2, createWordCounterWith("word word").count());
    }

    @Test
    public void should_return_0_for_a_number() {
        assertEquals(0, createWordCounterWith("123").count());
    }

    @Test
    public void should_return_0_for_a_special_character() {
        assertEquals(0, createWordCounterWith("!").count());
    }

    @Test
    public void should_return_0_for_a_word_containing_special_character() {
        assertEquals(0, createWordCounterWith("he!!o").count());
    }

    @Test
    public void should_return_0_for_a_word_containing_number() {
        assertEquals(0, createWordCounterWith("he11o").count());
    }

    @Test
    public void should_return_1_for_a_regular_word_and_two_irregular_ones() {
        assertEquals(1, createWordCounterWith("Hi he11o, Dav!d").count());
    }

    private WordCounter createWordCounterWith(String text) {
        return new WordCounter(text);
    }

}
