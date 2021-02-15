package com.example;

import com.example.interfaceExample.InputReader;
import com.example.interfaceExample.WordCounter;
import com.example.util.ConsoleInputReader;
import com.example.util.DefaultWordCounter;

public class BootClass {
    public static void main(String[] args) {

        WordCounter wc = new DefaultWordCounter();
        InputReader reader = new ConsoleInputReader();
        Application app = new Application(reader, wc);
        app.executeApp();
    }
}
