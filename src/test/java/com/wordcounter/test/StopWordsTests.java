package com.wordcounter.test;

import com.wordcounter.StopWords.StopWords;
import com.wordcounter.StopWords.impl.StopWordsImpl;
import com.wordcounter.test.mock.TextFileReaderMock;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordsTests {

    @Test
    public void when_called_on_existing_file_than_return_list_of_word() {
        String mockedFileName = "stopwords.txt";
        URL fileUrl = TextFileReaderTests.class.getClassLoader().getResource(mockedFileName);
        TextFileReaderMock textFileReaderMock = new TextFileReaderMock();

        StopWords stopWords = new StopWordsImpl(textFileReaderMock, fileUrl.getFile());
        List<String> words = stopWords.getStopWords();

        assertEquals(4, words.size());
    }

    @Test
    public void when_called_on_missing_file_than_return_empty_list() {
        String mockedFileName = "stopwords_missing.txt";
        TextFileReaderMock textFileReaderMock = new TextFileReaderMock();

        StopWords stopWords = new StopWordsImpl(textFileReaderMock, mockedFileName);
        List<String> words = stopWords.getStopWords();

        assertEquals(0, words.size());
    }
}
