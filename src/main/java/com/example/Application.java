package com.example;

import com.example.interfaceExample.InputReader;
import com.example.interfaceExample.WordCounter;

public class Application {
    private InputReader inputReader;
    private WordCounter wordCounter;

    public Application(InputReader inputReader, WordCounter wordCounter) {
        this.inputReader = inputReader;
        this.wordCounter = wordCounter;
    }

    public void executeApp(){
        String userInput = inputReader.readLine();
        int count = wordCounter.countWords(userInput);
        System.out.println("Number of words: " + count);
    }
}
