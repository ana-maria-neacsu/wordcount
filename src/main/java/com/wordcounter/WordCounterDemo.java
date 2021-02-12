package com.wordcounter;

import com.wordcounter.TextParser.TextParser;
import com.wordcounter.TextParser.impl.TextParserImpl;
import com.wordcounter.TextReader.TextReader;
import com.wordcounter.TextReader.impl.ConsoleFileReader;

public class WordCounterDemo {

    public static void main(String[] args) {
//        String text = "text";

        TextReader reader = new ConsoleFileReader();
        TextParser parser = new TextParserImpl(" ");

        String text = reader.readText();
        WordCounter wordCounter = new WordCounter(text, parser);
        wordCounter.countWords();
    }
}
