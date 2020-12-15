package com.george.domain;

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
        CountResult result = counter.count(word);
        Assert.assertEquals(0, result.getTotalWords());

    }

    @Test
    public void shouldReturn4WhenFiveWordSentenceIsInformedWithOneStopWord() {

        String word = "Mary had a little lamb";
        CountResult result= counter.count(word);

        Assert.assertEquals(4, result.getTotalWords());

    }

    @Test
    public void shouldReturn3WhenFiveWordSentenceIsInformedButOneWordIsInvalidAndOneStopWordIsPresent() {

        String word = "Mary had a little lamb*";
        CountResult result = counter.count(word);

        Assert.assertEquals(3, result.getTotalWords());

    }

    @Test
    public void shouldReturn0WhenFiveWordSentenceIsInformedButOneStopWordIsPresentAndOthersAreAllInvalid() {

        String word = "Mar3y ha4d a litt1le lamb*";
        CountResult result = counter.count(word);

        Assert.assertEquals(0, result.getTotalWords());

    }

    @Test
    public void shouldReturn9TotalWordsAnd7UniqueWordsForSampleInput(){
        String word = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        CountResult result = counter.count(word);
        Assert.assertEquals(9, result.getTotalWords());
        Assert.assertEquals(7, result.getUniqueWords());
    }

}