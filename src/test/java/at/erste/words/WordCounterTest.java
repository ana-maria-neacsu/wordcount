package at.erste.words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    WordCounter wordCounter;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        StopWords stopWords = new StopWords("stopwords.txt");
        wordCounter = new WordCounter(stopWords);
    }

    @Test
    void testOneWord() {
        assertEquals(1, wordCounter.count("word"));
    }

    @Test
    void testTwoWords () {
        assertEquals(2, wordCounter.count("word word"));
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