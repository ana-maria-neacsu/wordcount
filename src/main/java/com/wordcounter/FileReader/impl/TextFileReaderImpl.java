package com.wordcounter.FileReader.impl;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextFileReaderImpl implements com.wordcounter.FileReader.FileReader {
    @Override
    public List<String> readFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File file = new File(fileName);
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
