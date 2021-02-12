package com.wordcounter.StopWords.impl;

import com.wordcounter.FileReader.impl.TextFileReaderImpl;
import com.wordcounter.StopWords.StopWords;

import java.util.List;

public class StopWordsImpl implements StopWords {
    private TextFileReaderImpl reader;

    public StopWordsImpl(
//            FileReader reader
    ) {
    }

    @Override
    public List<String> getStopWords() {

        return null;
    }

    private List<String> readWords() {
        return this.reader.readFile();
    }
}
