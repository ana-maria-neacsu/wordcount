package at.erste.words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class WordCounterWithStopWords {

    WordCounter wordCounter;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        StopWords stopWords = new StopWords("stopwords.txt");
        wordCounter = new WordCounter(stopWords);
    }

    @Test
    void testWordWithOneStopWord() {
        assertEquals(0, wordCounter.count("a"));
    }

    @Test
    void testWordWithTwoStopWord() {
        assertEquals(0, wordCounter.count("a the"));
    }

    @Test
    void testWordsContainingStopWord() {
        assertEquals(4, wordCounter.count("Mary had a little lamb"));
    }

    @Test
    void testStopWordAndSpecialCharacter() {
        assertEquals(0, wordCounter.count("a&"));
    }

}