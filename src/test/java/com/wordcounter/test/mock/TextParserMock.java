package com.wordcounter.test.mock;

import com.wordcounter.TextParser.TextParser;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TextParserMock implements TextParser {
    private String delimiter;

    public TextParserMock(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<String> getTokensWithCollection(String text) {
        return Collections.list(new StringTokenizer(text, this.delimiter)).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
    }
}
