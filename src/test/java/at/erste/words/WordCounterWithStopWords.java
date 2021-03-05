package at.erste.words;

import at.erste.words.stopwords.StopWords;
import at.erste.words.stopwords.StopWordsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterWithStopWords {

    WordCounter wordCounter;

    @BeforeEach
    public void setUp() {
        StopWords stopWords = new StopWordsImpl("stopwords.txt");
        wordCounter = new WordCounter(Optional.of(stopWords));
    }

    @Test
    public void testWordWithOneStopWord() {
        assertEquals(0, wordCounter.calculateResult("a").getCount());
        assertEquals(0, wordCounter.calculateResult("a").getUniqueWordsCount());
    }

    @Test
    public void testWordWithTwoStopWord() {
        assertEquals(0, wordCounter.calculateResult("a the").getCount());
        assertEquals(0, wordCounter.calculateResult("a the").getUniqueWordsCount());
    }

    @Test
    public void testWordsContainingStopWord() {
        assertEquals(4, wordCounter.calculateResult("Mary had a little lamb").getCount());
        assertEquals(4, wordCounter.calculateResult("Mary had a little lamb").getUniqueWordsCount());
    }

    @Test
    public void testStopWordAndSpecialCharacter() {
        assertEquals(0, wordCounter.calculateResult("a&").getCount());
        assertEquals(0, wordCounter.calculateResult("a&").getUniqueWordsCount());
    }

    @Test
    public void testWordsWithSpecialCharacters() {
        assertEquals(9, wordCounter.calculateResult("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getCount());
        assertEquals(7, wordCounter.calculateResult("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getUniqueWordsCount());
    }
}