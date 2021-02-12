package com.wordcounter;

import com.wordcounter.TextParser.TextParser;
import com.wordcounter.TextParser.TextParserImpl;

public class WordCounterDemo {

    public static void main(String[] args) {
        String text = "text";

        TextParser parser = new TextParserImpl(" ");

        WordCounter wordCounter = new WordCounter(text, parser);
        wordCounter.countWords();
    }
}
