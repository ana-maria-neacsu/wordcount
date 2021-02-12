package com.wordcounter.test;

import com.wordcounter.TextParser.TextParser;
import com.wordcounter.TextParser.impl.TextParserImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextParserTests {

    @Test
    public void when_2_tokens_input_than_return_list_of_2() {
        String textInput = "word word";
        String delimiter = " ";

        TextParser parser = new TextParserImpl(delimiter);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(2, tokens.size());
    }

    @Test
    public void when_2_tokens__and_1_empty_input_than_return_list_of_2() {
        String textInput = "";
        String delimiter = "word ";

        TextParser parser = new TextParserImpl(delimiter);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(0, tokens.size());
    }

    @Test
    public void when_1_token_input_than_return_list_of_1() {
        String textInput = "";
        String delimiter = "word";

        TextParser parser = new TextParserImpl(delimiter);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(0, tokens.size());
    }

    @Test
    public void when_empty_text_input_than_return_empty_list() {
        String textInput = "";
        String delimiter = "";

        TextParser parser = new TextParserImpl(delimiter);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(0, tokens.size());
    }

    @Test
    public void when_just_delimiter_input_than_return_empty_list() {
        String textInput = "";
        String delimiter = " ";

        TextParser parser = new TextParserImpl(delimiter);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(0, tokens.size());
    }
}
