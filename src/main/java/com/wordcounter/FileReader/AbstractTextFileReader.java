package com.wordcounter.FileReader;

import java.util.List;

public class AbstractTextFileReader implements FileReader {

    protected String fileName = "";

    @Override
    public List<String> readFile() {
        return null;
    }

    public void setup(String fileName) {
        this.fileName = fileName;
    }
}
