package com.george.app;

import com.george.domain.filebasedcounter.FileConditionedWordCounter;
import com.george.ports.ConsoleInputReader;
import com.george.ports.FileReader;

public class Starter {

    private static final String STOP_WORDS = "stopwords.txt";

    public static void main(String[] args) {
        String input = "";

        if (args.length > 0) {
            input = new FileReader(args[0]).read();
        } else
            input = new ConsoleInputReader().read();

        final String stopWords = new FileReader(STOP_WORDS).read();
        System.out.println(new FileConditionedWordCounter(stopWords).count(input));

    }
}
