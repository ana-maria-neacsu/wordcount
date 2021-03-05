package at.erste.words.stopwords;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StopWordsImplReadTest {

    @Test
    public void testStopWordsEquals() {
        StopWordsImpl stopWords = new StopWordsImpl("stopwords.txt");
        assertEquals(stopWords.getStopWords(), asList("the", "a", "on", "off"));
    }

    @Test
    public void testStopWordsNotEquals() {
        StopWordsImpl stopWords = new StopWordsImpl("stopwords.txt");
        assertNotEquals(stopWords.getStopWords(), asList("the", "a", "on"));
    }
}