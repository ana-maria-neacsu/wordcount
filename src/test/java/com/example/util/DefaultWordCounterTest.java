package com.example.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefaultWordCounterTest {

    @Test
    public void testCountWords() {
        DefaultWordCounter testCounter = new DefaultWordCounter();
        Assertions.assertEquals(0, testCounter.countWords(""));
    }
}
