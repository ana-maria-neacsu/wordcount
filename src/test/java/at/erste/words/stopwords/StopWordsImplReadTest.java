package at.erste.words.stopwords;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StopWordsImplReadTest {

    @Test
    public void testStopWordsEquals() {
        StopWords stopWords = new StopWordsImpl("stopwords.txt");
        assertEquals(stopWords.getStopWords(), new HashSet<>(asList("a", "on", "off", "the")));
    }

    @Test
    public void testStopWordsNotEquals() {
        StopWords stopWords = new StopWordsImpl("stopwords.txt");
        assertNotEquals(stopWords.getStopWords(), asList("the", "a", "on"));
    }
}