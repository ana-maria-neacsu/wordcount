package at.erste.words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    WordCounter wordCounter;

    @BeforeEach
    void setUp() {
        wordCounter = new WordCounter(empty());
    }


    @Test
    void testOneWord() {
        assertEquals(1, wordCounter.count("word"));
    }

    @Test
    void testTwoWords() {
        assertEquals(2, wordCounter.count("word word"));
    }

    @Test
    void testTwoWordsWithTwoSpaces() {
        assertEquals(2, wordCounter.count("word  word"));
    }

    @Test
    void testTwoWordsWithTabulator() {
        assertEquals(2, wordCounter.count("word \t word"));
    }

    @Test
    void testWordWithNumbersEnding() {
        assertEquals(0, wordCounter.count("word1"));
    }

    @Test
    void testWordWithNumbersStarting() {
        assertEquals(0, wordCounter.count("1word"));
    }

    @Test
    void testWordWithSpecialCharactersStarting() {
        assertEquals(0, wordCounter.count("#word"));
    }

    @Test
    void testWordWithSpecialCharactersEnding() {
        assertEquals(0, wordCounter.count("word!"));
    }


}