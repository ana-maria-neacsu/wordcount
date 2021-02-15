package com.example;

import com.example.interfaceExample.InputReader;
import com.example.interfaceExample.WordCounter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {
    private InputReader inputReader;
    private WordCounter wordCounter;

    public Application(InputReader inputReader, WordCounter wordCounter) {
        this.inputReader = inputReader;
        this.wordCounter = wordCounter;
    }

    public void executeApp(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/stopwords.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines != null) {
            for (String line: lines) {
                System.out.println(line);
            }
        }
       /* String userInput = inputReader.readInput();

        int count = wordCounter.countWords(userInput);
        System.out.println("Number of words: " + count);*/
    }
}
