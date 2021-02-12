package com.wordcounter;

import com.wordcounter.TextParser.TextParser;
import com.wordcounter.TextParser.impl.TextParserImpl;
import com.wordcounter.TextReader.TextReader;
import com.wordcounter.TextReader.impl.ConsoleTextReader;

public class WordCounterDemo {

    public static void main(String[] args) {

        TextReader reader = new ConsoleTextReader();
        String text = reader.readText();

        TextParser parser = new TextParserImpl(" ");

        WordCounter wordCounter = new WordCounter(text, parser);
        Long wordNumber = wordCounter.countWords();

        System.out.print(wordNumber);
    }
}
