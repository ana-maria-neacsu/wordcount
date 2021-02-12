package com.wordcounter.test;

import com.wordcounter.WordCounter;
import com.wordcounter.test.mock.TextParserMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTests {

    @Test
    public void when_2_words_input_than_count_2() {
        String textInput = "word word";
        String textDelimiter = " ";
        TextParserMock parserMock = new TextParserMock(textDelimiter);

        WordCounter counter = new WordCounter(textInput, parserMock);
        Long wordsNumber = counter.countWords();

        assertEquals(2, wordsNumber);
    }

    @Test
    public void when_0_words_input_than_count_0() {
        String textInput = "";
        String textDelimiter = " ";
        TextParserMock parserMock = new TextParserMock(textDelimiter);

        WordCounter counter = new WordCounter(textInput, parserMock);
        Long wordsNumber = counter.countWords();

        assertEquals(0, wordsNumber);
    }

    @Test
    public void when_invalid_words_input_than_count_0() {
        String textInput = "word2word";
        String textDelimiter = " ";
        TextParserMock parserMock = new TextParserMock(textDelimiter);

        WordCounter counter = new WordCounter(textInput, parserMock);
        Long wordsNumber = counter.countWords();

        assertEquals(0, wordsNumber);
    }

    @Test
    public void when_2_words_input_and_1_is_stopword_than_count_1() {
        String textInput = "word word";
        String textDelimiter = " ";
        TextParserMock parserMock = new TextParserMock(textDelimiter);

        WordCounter counter = new WordCounter(textInput, parserMock);
        Long wordsNumber = counter.countWords();

        assertEquals(0, wordsNumber);
    }
}
