package com.wordcounter.test;

import com.wordcounter.StopWordsReader.StopWordsReader;
import com.wordcounter.StopWordsReader.impl.StopWordsReaderImpl;
import com.wordcounter.test.mock.TextFileReaderMock;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordsReaderTests {

    private static final String MISSING_MOCKED_STOPPED_FILE_NAME = "stopwords_missing.txt";
    private static final String MOCKED_STOPPED_FILE_NAME = "stopwords.txt";

    @Test
    public void when_called_on_existing_file_than_return_list_of_word() {
        URL fileUrl = TextFileReaderTests.class.getClassLoader().getResource(MOCKED_STOPPED_FILE_NAME);
        TextFileReaderMock textFileReaderMock = new TextFileReaderMock();

        StopWordsReader stopWords = new StopWordsReaderImpl(textFileReaderMock, fileUrl.getFile());
        List<String> words = stopWords.getStopWords();

        assertEquals(4, words.size());
    }

    @Test
    public void when_called_on_missing_file_than_return_empty_list() {
        TextFileReaderMock textFileReaderMock = new TextFileReaderMock();

        StopWordsReader stopWords = new StopWordsReaderImpl(textFileReaderMock, MISSING_MOCKED_STOPPED_FILE_NAME);
        List<String> words = stopWords.getStopWords();

        assertEquals(0, words.size());
    }
}
