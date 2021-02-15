package com.example;

import com.example.interfaceExample.InputReader;
import com.example.interfaceExample.WordCounter;
import com.example.util.ConsoleInputReader;
import com.example.util.DefaultWordCounter;
import com.example.util.FileParser;
import com.example.util.StopwordsDictionary;

import java.nio.file.Paths;

public class BootClass {
    public static void main(String[] args) {

        FileParser parser = new FileParser(Paths.get("src/main/resources/stopwords.txt"));
        StopwordsDictionary stopwordsDictionary = new StopwordsDictionary();
        stopwordsDictionary.loadStopWords(parser.parseList());
        WordCounter wc = new DefaultWordCounter(stopwordsDictionary.getStopWords());
        InputReader reader = new ConsoleInputReader();
        Application app = new Application(reader, wc);
        app.executeApp();
    }
}
