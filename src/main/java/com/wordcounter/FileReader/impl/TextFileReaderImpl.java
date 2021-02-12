package com.wordcounter.FileReader.impl;

import com.wordcounter.FileReader.AbstractTextFileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextFileReaderImpl extends AbstractTextFileReader {

//    private List<String> fileLines = Collections.emptyList();

    @Override
    public List<String> readFile() {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File file = new File(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
        }
        ;

        return lines;
    }
}
