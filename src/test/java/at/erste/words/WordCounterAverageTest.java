package at.erste.words;

import org.junit.jupiter.api.Test;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterAverageTest {

    WordCounter wordCounter = new WordCounter(empty());

    @Test
    public void testAverageSizes() {
        assertEquals(4, wordCounter.calculateResult("word").getAverageSize());
        assertEquals(4, wordCounter.calculateResult("word word").getAverageSize());
        assertEquals(3, wordCounter.calculateResult("word wo").getAverageSize());
        assertEquals(1.5, wordCounter.calculateResult("wo b").getAverageSize());
        assertEquals(1.5, wordCounter.calculateResult("wo! b").getAverageSize());
    }
}