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
        assertEquals(1, wordCounter.calculateResult("word").getCount());
        assertEquals(1, wordCounter.calculateResult("word").getUniqueWordsCount());
    }

    @Test
    void testTwoWords() {
        assertEquals(2, wordCounter.calculateResult("word word").getCount());
        assertEquals(1, wordCounter.calculateResult("word word").getUniqueWordsCount());
    }

    @Test
    void testTwoWordsWithTwoSpaces() {
        assertEquals(2, wordCounter.calculateResult("word  word").getCount());
        assertEquals(1, wordCounter.calculateResult("word  word").getUniqueWordsCount());
    }

    @Test
    void testTwoWordsWithTabulator() {
        assertEquals(2, wordCounter.calculateResult("word \t word").getCount());
        assertEquals(1, wordCounter.calculateResult("word \t word").getUniqueWordsCount());
    }

    @Test
    void testWordWithNumbersEnding() {
        assertEquals(0, wordCounter.calculateResult("word1").getCount());
        assertEquals(0, wordCounter.calculateResult("word1").getUniqueWordsCount());
    }

    @Test
    void testWordWithNumbersStarting() {
        assertEquals(0, wordCounter.calculateResult("1word").getCount());
        assertEquals(0, wordCounter.calculateResult("1word").getUniqueWordsCount());
    }

    @Test
    void testWordWithSpecialCharactersStarting() {
        assertEquals(0, wordCounter.calculateResult("#word").getCount());
        assertEquals(0, wordCounter.calculateResult("#word").getUniqueWordsCount());
    }

    @Test
    void testWordWithSpecialCharactersEnding() {
        assertEquals(0, wordCounter.calculateResult("word!").getCount());
        assertEquals(0, wordCounter.calculateResult("word!").getUniqueWordsCount());
    }
}