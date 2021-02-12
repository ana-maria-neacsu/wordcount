package com.wordcounter.TextParser.impl;

import com.wordcounter.TextParser.TextParser;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TextParserImpl implements TextParser {

    private String delimiter;

    public TextParserImpl(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<String> getTokensWithCollection(String text) {
        return Collections.list(new StringTokenizer(text, this.delimiter)).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
    }
}
