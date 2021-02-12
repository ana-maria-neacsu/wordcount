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
    public void when_called_than_return_list_of_word() {
        String mockedFileName = "stopwords.txt";
        URL fileUrl = TextFileReaderTests.class.getClassLoader().getResource(mockedFileName);
        TextFileReaderMock textFileReaderMock = new TextFileReaderMock();
        textFileReaderMock.setup(fileUrl.getFile());

        StopWords stopWords = new StopWordsImpl(textFileReaderMock);
        List<String> words = stopWords.getStopWords();

        assertEquals(4, words.size());
    }
}
