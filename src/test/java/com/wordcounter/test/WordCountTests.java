package com.wordcounter.test;

import com.wordcounter.StopWordsReader.StopWordsReader;
import com.wordcounter.WordCounter;
import com.wordcounter.test.mock.StopWordsReaderMock;
import com.wordcounter.test.mock.TextParserMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTests {

    private static final String TEXT_DELIMITER = " ";
    private static final String EMPTY_MOCKED_STOPPED_FILE_NAME = "";
    private static final String MOCKED_STOPPED_FILE_NAME = "stopwords.txt";

    @Test
    public void when_2_words_input_and_no_stop_words_than_count_2() {
        String textInput = "word word";
        TextParserMock parserMock = new TextParserMock(TEXT_DELIMITER);
        StopWordsReader stopWordsReaderMock = new StopWordsReaderMock().buildtMock(EMPTY_MOCKED_STOPPED_FILE_NAME);

        WordCounter counter = new WordCounter(textInput, parserMock, stopWordsReaderMock);
        Long wordsNumber = counter.countWords();

        assertEquals(2, wordsNumber);
    }

    @Test
    public void when_0_words_input_and_no_stop_words_than_count_0() {
        String textInput = "";
        TextParserMock parserMock = new TextParserMock(TEXT_DELIMITER);
        StopWordsReader stopWordsReaderMock = new StopWordsReaderMock().buildtMock(EMPTY_MOCKED_STOPPED_FILE_NAME);


        WordCounter counter = new WordCounter(textInput, parserMock, stopWordsReaderMock);
        Long wordsNumber = counter.countWords();

        assertEquals(0, wordsNumber);
    }

    @Test
    public void when_invalid_words_input_and_no_stop_words_than_count_0() {
        String textInput = "word2word";
        TextParserMock parserMock = new TextParserMock(TEXT_DELIMITER);
        StopWordsReader stopWordsReaderMock = new StopWordsReaderMock().buildtMock(EMPTY_MOCKED_STOPPED_FILE_NAME);

        WordCounter counter = new WordCounter(textInput, parserMock, stopWordsReaderMock);
        Long wordsNumber = counter.countWords();

        assertEquals(0, wordsNumber);
    }

    @Test
    public void when_2_words_input_and_1_is_stop_word_than_count_1() {
        String textInput = "word on";
        TextParserMock parserMock = new TextParserMock(TEXT_DELIMITER);
        StopWordsReader stopWordsReaderMock = new StopWordsReaderMock().buildtMock(MOCKED_STOPPED_FILE_NAME);

        WordCounter counter = new WordCounter(textInput, parserMock, stopWordsReaderMock);
        Long wordsNumber = counter.countWords();

        assertEquals(1, wordsNumber);
    }

    @Test
    public void when_2_words_input_and_2_is_stop_word_than_count_0() {
        String textInput = "off on";
        TextParserMock parserMock = new TextParserMock(TEXT_DELIMITER);
        StopWordsReader stopWordsReaderMock = new StopWordsReaderMock().buildtMock(MOCKED_STOPPED_FILE_NAME);

        WordCounter counter = new WordCounter(textInput, parserMock, stopWordsReaderMock);
        Long wordsNumber = counter.countWords();

        assertEquals(0, wordsNumber);
    }
}
