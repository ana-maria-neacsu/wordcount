package com.george.app;

import com.george.domain.CountResult;
import com.george.domain.InputReader;
import com.george.ports.ConsoleInputReader;
import com.george.ports.FileReader;
import com.george.ports.UserInteractor;

import java.util.Scanner;

public class Starter {

    private static final String STOP_WORDS = "stopwords.txt";

    public static void main(String[] args) {
        InputReader inputReader;

        final String stopWords = new FileReader(STOP_WORDS).read();
        if (args.length > 0) {
            inputReader = new FileReader(args[0]);
        } else
            inputReader = new ConsoleInputReader(new UserInteractor(new Scanner(System.in)));

        CountResult wordsCount = new InputMethodSelector(inputReader, stopWords).apply();

        System.out.println("Number of words: " + wordsCount.getTotalWords() + ", unique: " + wordsCount.getUniqueWords()
        + "; average word length: " + wordsCount.getAverage() + " characters");

    }
}
