package com.wordcounter.TextParser;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class TextParserImpl implements TextParser {

    private String text;
    private String delimiter;

    public TextParserImpl(String text, String delimiter) {
        this.text = text;
        this.delimiter = delimiter;
    }

    public List<String> getTokensWithCollection() {
        return Collections.list(new StringTokenizer(this.text, this.delimiter)).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
    }
}
