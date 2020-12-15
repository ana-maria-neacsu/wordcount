package com.george.domain;

import com.george.domain.filebasedcounter.StopWordsConditionedWordCounter;
import com.george.ports.FileReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StopWordsConditionedWordCounterTest {

    private final InputReader reader = new FileReader("stopwords.txt");
    private WordCounter counter;
    private String stopWords;

    @Before
    public void setUp(){
        stopWords = reader.read();
        counter = new StopWordsConditionedWordCounter(stopWords);
    }

    @Test
    public void shouldReturn0WhenNoWordIsInformed() {

        String word = "";
        long result = counter.count(word);
        Assert.assertEquals(0, result);

    }

    @Test
    public void shouldReturn4WhenFiveWordSentenceIsInformedWithOneStopWord() {

        String word = "Mary had a little lamb";
        long result = counter.count(word);

        Assert.assertEquals(4, result);

    }

    @Test
    public void shouldReturn3WhenFiveWordSentenceIsInformedButOneWordIsInvalidAndOneStopWordIsPresent() {

        String word = "Mary had a little lamb*";
        long result = counter.count(word);

        Assert.assertEquals(3, result);

    }

    @Test
    public void shouldReturn0WhenFiveWordSentenceIsInformedButOneStopWordIsPresentAndOthersAreAllInvalid() {

        String word = "Mar3y ha4d a litt1le lamb*";
        long result = counter.count(word);

        Assert.assertEquals(0, result);

    }

}