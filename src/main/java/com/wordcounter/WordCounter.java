package com.wordcounter;

import com.wordcounter.TextParser.TextParser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private String text;
    private TextParser parser;
    private List<String> words;

    public WordCounter(String text, TextParser parser) {
        this.text = text;
        this.parser = parser;
    }

    public Long countWords() {
        List<String> tokens = this.getTokens();
        this.words = this.convertTokensToWords(tokens);
        return Long.valueOf(this.words.size());
    }

    private List<String> getTokens() {
        return this.parser.getTokensWithCollection(text);
    }

    private List<String> convertTokensToWords(List<String> tokens) {
        return tokens.stream()
                .filter(token -> this.checkTokenIsWord(token) == true)
                .collect(Collectors.toList());
    }

    private Boolean checkTokenIsWord(String token) {
        String pattern = "[a-zA-Z]+";
        Pattern wordPattern = Pattern.compile(pattern);
        Matcher wordPatternMatcher = wordPattern.matcher(token);
        return wordPatternMatcher.matches();
    }
}
