package com.george.app;

import com.george.domain.CountResult;
import com.george.domain.InputReader;
import com.george.ports.ConsoleInputReader;
import com.george.ports.FileReader;
import com.george.ports.UserInteractor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    private static final String STOP_WORDS = "stopwords.txt";

    private static DecimalFormat df = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US));

    private final String[] args;
    private final InputReader reader;
    private final String stopWords;
    private final InputMethodSelector selector;

    public Application(String[] args) {
        this.args = args;
        reader = properReader();
        stopWords = new FileReader(STOP_WORDS).read();
        selector = new InputMethodSelector(reader, stopWords);
    }

    public String run() {
        CountResult wordsCount = selector.apply();
        return "Number of words: " + wordsCount.getTotalWords() + ", unique: " + wordsCount.getUniqueWords()
                + "; average word length: " + df.format(wordsCount.getAverageLength()) + " characters";
    }

    private InputReader properReader() {
        if (args.length > 0)
            return new FileReader(args[0]);
        else
            return new ConsoleInputReader(new UserInteractor(new Scanner(System.in)));
    }

}
