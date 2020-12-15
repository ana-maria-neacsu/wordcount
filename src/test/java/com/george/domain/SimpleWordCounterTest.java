package com.george.domain;

import com.george.domain.consolebasedcounter.SimpleWordCounter;
import org.junit.Assert;
import org.junit.Test;

public class SimpleWordCounterTest {

    private WordCounter counter = new SimpleWordCounter();

    @Test
    public void shouldReturn0WhenNoWordIsInformed() {

        String word = "";
        long result = counter.count(word);
        Assert.assertEquals(0, result);

    }

    @Test
    public void shouldReturn5WhenFiveWordSentenceIsInformed() {

        String word = "Mary had a little lamb";
        long result = counter.count(word);

        Assert.assertEquals(5, result);

    }

    @Test
    public void shouldReturn4WhenFiveWordSentenceIsInformedButOneWordIsInvalid() {

        String word = "Mary had a little lamb*";
        long result = counter.count(word);

        Assert.assertEquals(4, result);

    }

}