package com.george.ports;

import com.george.domain.InputReader;
import com.george.domain.InputUnreachableException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements InputReader {

    private final String fileName;

    public FileReader(String fileName){
        this.fileName = fileName;
    }

    @Override
    public String read() {

        StringBuilder allWords = new StringBuilder();
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                allWords.append(scanner.nextLine()).append(" ");
            }
        } catch (FileNotFoundException e) {
            throw new InputUnreachableException("file not found", e);
        }
        return allWords.toString();
    }
}
