package com.wordcounter.TextReader.impl;

import com.wordcounter.TextReader.TextReader;

import java.io.Console;

public class ConsoleFileReader implements TextReader {
    @Override
    public String readText() {
        Console console = System.console();
        System.out.println("Enter text:");
        String text = console.readLine();
        return text;
    }
}
