package com.wordcounter.test.mock;

import com.wordcounter.FileReader.FileReader;
import com.wordcounter.FileReader.impl.TextFileReaderImpl;
import com.wordcounter.StopWordsReader.StopWordsReader;
import com.wordcounter.StopWordsReader.impl.StopWordsReaderImpl;
import com.wordcounter.WordCounterDemo;

import java.net.URL;
import java.util.List;

public class StopWordsReaderMock implements StopWordsReader {

    public StopWordsReader buildtMock(String mockedStopFileName) {
        FileReader textFileReader = new TextFileReaderImpl();

        URL fileUrl = WordCounterDemo.class.getClassLoader().getResource(mockedStopFileName);
        StopWordsReader stopWordsReader = new StopWordsReaderImpl(textFileReader, fileUrl.getFile());

        return stopWordsReader;
    }

    @Override
    public List<String> getStopWords() {
        return null;
    }
}
