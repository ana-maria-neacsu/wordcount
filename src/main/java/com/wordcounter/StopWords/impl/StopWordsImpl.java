package com.wordcounter.StopWords.impl;

import com.wordcounter.FileReader.FileReader;
import com.wordcounter.StopWords.StopWords;

import java.util.List;

public class StopWordsImpl implements StopWords {
    private FileReader reader;

    public StopWordsImpl(FileReader reader) {
        this.reader = reader;
    }

    @Override
    public List<String> getStopWords() {
        return this.readWords();
    }

    private List<String> readWords() {
        return this.reader.readFile();
    }
}
