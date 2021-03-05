package at.erste.words;

import at.erste.words.stopwords.StopWords;
import at.erste.words.stopwords.StopWordsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterWithStopWords {

    WordCounter wordCounter;

    @BeforeEach
    void setUp() {
        StopWords stopWords = new StopWordsImpl("stopwords.txt");
        wordCounter = new WordCounter(Optional.of(stopWords));
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