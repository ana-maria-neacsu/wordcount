package at.erste.words;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StopWordsReadTest {


    @Test
    void testStopWordsEquals() throws FileNotFoundException {
        StopWords stopWords = new StopWords("stopwords.txt");
        assertEquals(stopWords.getStopWords(), asList("the", "a", "on", "off"));
    }

    @Test
    void testStopWordsNotEquals() throws FileNotFoundException {
        StopWords stopWords = new StopWords("stopwords.txt");
        assertNotEquals(stopWords.getStopWords(), asList("the", "a", "on"));
    }
}