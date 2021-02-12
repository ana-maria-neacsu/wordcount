package com.wordcounter;

import com.wordcounter.TextParser.TextParser;

import java.util.List;

public class WordCounter {

    private String text;
    private TextParser parser;

    public WordCounter(String text, TextParser parser) {
        this.text = text;
        this.parser = parser;
    }

    public Long countWords() {
        List<String> tokens = this.getTokens();
        return Long.valueOf(tokens.size());
    }

    private List<String> getTokens() {
        return parser.getTokensWithCollection(text);
    }
}
