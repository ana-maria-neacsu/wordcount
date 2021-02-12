package com.wordcounter.test;

import com.wordcounter.WordCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTests {

    @Test
    public void when_2_words_input_than_count_2() {
        String textInput = "word word";

        WordCounter counter = new WordCounter();
        Long wordsNumber = counter.count(textInput);

        assertEquals(2, wordsNumber);
    }

    @Test
    public void when_0_words_input_than_count_0() {
        String textInput = "";

        WordCounter counter = new WordCounter();
        Long wordsNumber = counter.count(textInput);

        assertEquals(0, wordsNumber);
    }

    @Test
    public void when_invalid_words_input_than_count_0() {
        String textInput = "word2word";

        WordCounter counter = new WordCounter();
        Long wordsNumber = counter.count(textInput);

        assertEquals(0, wordsNumber);
    }
}
