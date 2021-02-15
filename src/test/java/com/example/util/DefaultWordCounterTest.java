package com.example.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class DefaultWordCounterTest {

    @Test
    public void testCountWordsEmptyString() {
        DefaultWordCounter testCounter = new DefaultWordCounter(new HashSet<>());
        int count = testCounter.countWords("");
        Assertions.assertEquals(0, count);
    }

    @Test
    public void testCountWordsLongString() {
        DefaultWordCounter testCounter = new DefaultWordCounter(new HashSet<>());
        int count = testCounter.countWords("1231 5456 545 word word word 123?? ?word");
        Assertions.assertEquals(3, count);
    }

    @Test
    public void testCountWordsOneCorrectWord() {
        DefaultWordCounter testCounter = new DefaultWordCounter(new HashSet<>());
        int count = testCounter.countWords("word");
        Assertions.assertEquals(1, count);
    }
    @Test
    public void testCountWordsOneIncorrectWord() {
        DefaultWordCounter testCounter = new DefaultWordCounter(new HashSet<>());
        int count = testCounter.countWords("?word");
        Assertions.assertEquals(3, count);
    }

}
