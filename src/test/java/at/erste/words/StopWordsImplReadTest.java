package at.erste.words;

import at.erste.words.stopwords.StopWordsImpl;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StopWordsImplReadTest {


    @Test
    void testStopWordsEquals() throws FileNotFoundException {
        StopWordsImpl stopWords = new StopWordsImpl("stopwords.txt");
        assertEquals(stopWords.getStopWords(), asList("the", "a", "on", "off"));
    }

    @Test
    void testStopWordsNotEquals() throws FileNotFoundException {
        StopWordsImpl stopWords = new StopWordsImpl("stopwords.txt");
        assertNotEquals(stopWords.getStopWords(), asList("the", "a", "on"));
    }
}