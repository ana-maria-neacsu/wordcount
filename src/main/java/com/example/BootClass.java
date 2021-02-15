package com.example;

import com.example.interfaceExample.InputReader;
import com.example.interfaceExample.WordCounter;
import com.example.util.*;

import java.nio.file.Paths;

public class BootClass {
    public static void main(String[] args) {

        InputReader reader;
        if (args.length > 0) {
            reader = new FileInputReader(args[0]);
        } else {
            reader = new ConsoleInputReader();
        }

        FileParser parser = new FileParser(Paths.get("src/main/resources/stopwords.txt"));
        StopwordsDictionary stopwordsDictionary = new StopwordsDictionary();
        stopwordsDictionary.loadStopWords(parser.parseList());
        WordCounter wc = new DefaultWordCounter(stopwordsDictionary.getStopWords());
        Application app = new Application(reader, wc);
        app.executeApp();
    }
}
