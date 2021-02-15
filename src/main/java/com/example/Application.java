package com.example;

import com.example.interfaceExample.InputReader;
import com.example.interfaceExample.WordCounter;


public class Application {
    private final InputReader inputReader;
    private final WordCounter wordCounter;


    public Application(InputReader inputReader, WordCounter wordCounter) {
        this.inputReader = inputReader;
        this.wordCounter = wordCounter;
    }

    public void executeApp() {
        String userInput = inputReader.readInput();
        int count = wordCounter.countWords(userInput);
        System.out.println("Number of words: " + count);
    }
}
