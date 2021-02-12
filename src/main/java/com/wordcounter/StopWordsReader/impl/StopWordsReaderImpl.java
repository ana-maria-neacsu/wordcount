package com.wordcounter.StopWordsReader.impl;

import com.wordcounter.FileReader.FileReader;
import com.wordcounter.StopWordsReader.StopWordsReader;

import java.util.List;

public class StopWordsReaderImpl implements StopWordsReader {
    private FileReader reader;
    private String fileName = "";

    public StopWordsReaderImpl(FileReader reader, String fileName) {
        this.reader = reader;
        this.fileName = fileName;
    }

    @Override
    public List<String> getStopWords() {
        return this.readWords();
    }

    private List<String> readWords() {
        return this.reader.readFile(this.fileName);
    }
}
