package at.erste.words;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter();

    @Test
    public void testOneWord() {
        assertEquals(1, wordCounter.calculateResult("word").getCount());
        assertEquals(1, wordCounter.calculateResult("word").getUniqueWordsCount());
    }

    @Test
    public void testTwoWords() {
        assertEquals(2, wordCounter.calculateResult("word word").getCount());
        assertEquals(1, wordCounter.calculateResult("word word").getUniqueWordsCount());
    }

    @Test
    public void testTwoWordsWithTwoSpaces() {
        assertEquals(2, wordCounter.calculateResult("word  word").getCount());
        assertEquals(1, wordCounter.calculateResult("word  word").getUniqueWordsCount());
    }

    @Test
    public void testTwoWordsWithTabulator() {
        assertEquals(2, wordCounter.calculateResult("word \t word").getCount());
        assertEquals(1, wordCounter.calculateResult("word \t word").getUniqueWordsCount());
    }

    @Test
    public void testWordWithNumbersEnding() {
        assertEquals(0, wordCounter.calculateResult("word1").getCount());
        assertEquals(0, wordCounter.calculateResult("word1").getUniqueWordsCount());
    }

    @Test
    public void testWordWithNumbersStarting() {
        assertEquals(0, wordCounter.calculateResult("1word").getCount());
        assertEquals(0, wordCounter.calculateResult("1word").getUniqueWordsCount());
    }

    @Test
    public void testWordWithSpecialCharactersStarting() {
        assertEquals(1, wordCounter.calculateResult("#word").getCount());
        assertEquals(1, wordCounter.calculateResult("#word").getUniqueWordsCount());
    }

    @Test
    public void testWordWithSpecialCharactersEnding() {
        assertEquals(1, wordCounter.calculateResult("word!").getCount());
        assertEquals(1, wordCounter.calculateResult("word!").getUniqueWordsCount());
    }
}