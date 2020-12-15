package com.george.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WordPreparatorTest {

    private WordPreparator preparator = new WordPreparator("");

    @Test
    public void shouldConsiderWordsWithDotInTheEnd() {
        List<String> prepare = preparator.prepare("some.");
        Assert.assertEquals(1, prepare.size());
    }

    @Test
    public void shouldNotConsiderWordsWithDotInTheMiddle() {
        List<String> prepare = preparator.prepare("s.ome.");
        Assert.assertEquals(0, prepare.size());
    }

    @Test
    public void shouldSplitAWordSeparatedByDashesInto2Words() {
        List<String> prepare = preparator.prepare("some-word");
        Assert.assertEquals(2, prepare.size());
    }

    @Test
    public void shouldNotConsiderWordsWithDashNotInTheMiddle() {
        List<String> prepare = preparator.prepare("some-");
        Assert.assertEquals(0, prepare.size());
    }

}