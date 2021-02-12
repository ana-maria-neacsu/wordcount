package com.wordcounter;

import com.wordcounter.TextParser.TextParser;
import com.wordcounter.TextParser.TextParserImpl;

import java.util.List;

public class WordCounter {

    public Long count(String text) {

        TextParser parser = new TextParserImpl(text, " ");
        List<String> tokens = parser.getTokensWithCollection();
        return Long.valueOf(tokens.size());
    }
}
