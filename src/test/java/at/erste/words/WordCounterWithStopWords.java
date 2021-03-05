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
        assertEquals(0, wordCounter.calculateResult("a").getCount());
        assertEquals(0, wordCounter.calculateResult("a").getUniqueWordsCount());
    }

    @Test
    void testWordWithTwoStopWord() {
        assertEquals(0, wordCounter.calculateResult("a the").getCount());
        assertEquals(0, wordCounter.calculateResult("a the").getUniqueWordsCount());
    }

    @Test
    void testWordsContainingStopWord() {
        assertEquals(4, wordCounter.calculateResult("Mary had a little lamb").getCount());
        assertEquals(4, wordCounter.calculateResult("Mary had a little lamb").getUniqueWordsCount());
    }

    @Test
    void testStopWordAndSpecialCharacter() {
        assertEquals(0, wordCounter.calculateResult("a&").getCount());
        assertEquals(0, wordCounter.calculateResult("a&").getUniqueWordsCount());
    }

}