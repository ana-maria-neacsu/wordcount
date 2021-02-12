package com.wordcounter;

import com.wordcounter.TextParser.TextParser;
import com.wordcounter.TextParser.TextParserImpl;

import java.util.List;

public class WordCounter {

    private TextParser parser;

    public WordCounter(TextParser parser) {
        this.parser = parser;
    }

    public Long count(String text) {

//        TextParser parser = new TextParserImpl(text, " ");
        List<String> tokens = this.getTokens();

        return Long.valueOf(tokens.size());
    }

    private List<String> getTokens() {
        return parser.getTokensWithCollection();
    }
}
