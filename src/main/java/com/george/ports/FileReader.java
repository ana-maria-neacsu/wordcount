package com.george.ports;

import com.george.domain.InputReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements InputReader {

    private static final String STOP_WORDS = "stopwords.txt";

    @Override
    public String read() {

        StringBuilder allWords = new StringBuilder();
        File file = new File(STOP_WORDS);

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                allWords.append(scanner.nextLine() + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return allWords.toString();
    }
}
