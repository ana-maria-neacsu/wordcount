package at.george.wordcount;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class ResourceProviderTest {

    private final ResourceProvider resourceProvider = new ResourceProvider();

    @Test
    public void verifyReadStopWordsFileReading() {
        assertEquals(new HashSet<>(Arrays.asList("the", "a", "on", "off", "an", "this")), resourceProvider.fetchStopWords());
    }

    @Test
    public void verifyReadResource() {
        assertEquals(9, resourceProvider.fetchFromFile("/othertext.txt").size());
    }

    @Test(expected = ResourceProvider.ResourceNotFoundException.class)
    public void verifyCorrectExceptionOnFileNotFound() {
        resourceProvider.fetchFromFile("doesnotexist.txt");
    }

}