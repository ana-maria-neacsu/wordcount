package com.wordcounter.test;

import com.wordcounter.TextParser.TextParser;
import com.wordcounter.TextParser.impl.TextParserImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextParserTests {

    private static final String TEXT_DELIMITER = " ";

    @Test
    public void when_2_tokens_input_than_return_list_of_2() {
        String textInput = "word word";

        TextParser parser = new TextParserImpl(TEXT_DELIMITER);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(2, tokens.size());
    }

    @Test
    public void when_1_token_and_1_delimiter_input_than_return_list_of_1() {
        String textInput = "word ";

        TextParser parser = new TextParserImpl(TEXT_DELIMITER);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(1, tokens.size());
    }

    @Test
    public void when_1_token_input_than_return_list_of_1() {
        String textInput = "word";

        TextParser parser = new TextParserImpl(TEXT_DELIMITER);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(1, tokens.size());
    }

    @Test
    public void when_empty_text_input_than_return_empty_list() {
        String textInput = "";

        TextParser parser = new TextParserImpl(TEXT_DELIMITER);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(0, tokens.size());
    }

    @Test
    public void when_just_delimiter_input_than_return_empty_list() {
        String textInput = TEXT_DELIMITER;

        TextParser parser = new TextParserImpl(TEXT_DELIMITER);
        List<String> tokens = parser.getTokensWithCollection(textInput);

        assertEquals(0, tokens.size());
    }
}
