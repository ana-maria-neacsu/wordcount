package com.george.app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplicationIntegrationTest {

    private Application app;

    @Before
    public void setUp() {
        String args[] = {"randomWords.txt"};
        app = new Application(args);
    }

    @Test
    public void shouldReturnExactSentenceForInputFromFile() {
        final String expected = "Number of words: 14, unique: 13; average word length: 7.31 characters";
        final String actual = app.run();
        Assert.assertEquals(expected, actual);
    }
}