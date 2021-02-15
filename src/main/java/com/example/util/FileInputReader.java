package com.example.util;

import com.example.interfaceExample.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileInputReader implements InputReader {
    private final String fileName;

    public FileInputReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String readInput() {

        StringBuilder sb = new StringBuilder();
        InputStream inputStream = this.getClass().getResourceAsStream("/" + fileName);
        if (inputStream != null) {
            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append(" ");
                }
            } catch (IOException e) {
                //log in case of io exceptions
            }
        }
        return sb.toString();
    }
}
