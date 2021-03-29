package wordcounter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {

    @Test
    public void should_throw_exception_when_null_is_provided_for_text() {
        assertThrows(NullPointerException.class, () -> createWordCounterWith(null));
    }

    @Test
    public void should_throw_exception_when_null_is_provided_for_stop_words() {
        assertThrows(NullPointerException.class, () -> createWordCounterWith("some text", null));
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

    @Test
    public void should_return_0_when_only_stop_words_are_given() {
        Set<String> stopWords = new HashSet<>(asList("Hi", "we", "are", "stop", "words"));
        assertEquals(0, createWordCounterWith("Hi we are stop words", stopWords).count());
    }

    @Test
    public void should_return_1_for_one_regular_word_and_one_stop_word() {
        Set<String> stopWords = new HashSet<>(asList("Hi"));
        assertEquals(1, createWordCounterWith("Hi there", stopWords).count());
    }

    private WordCounter createWordCounterWith(String text) {
        return createWordCounterWith(text, Collections.emptySet());
    }

    private WordCounter createWordCounterWith(String text, Set<String> stopWords) {
        return new WordCounter(text, stopWords);
    }

}
