package com.example.util;

import com.example.interfaceExample.InputReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInputReader implements InputReader {
    private final String fileName;

    public FileInputReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String readInput() {

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            //log in case
        }
        return sb.toString();
    }
}
