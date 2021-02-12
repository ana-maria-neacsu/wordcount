package com.wordcounter.test;

import com.wordcounter.WordCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {

    @Test
    public void when_2_words_input_than_count_2() {
        String textInput = "word word";

        WordCounter counter = new WordCounter();
        Long wordsNumber = counter.count(textInput);

        assertEquals(2, wordsNumber);
    }

}
