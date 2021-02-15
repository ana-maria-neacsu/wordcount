package com.example.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class StopWordsDictionaryTest {

    @Test
    public void testLoadStopWordsOneWord() {
        HashSet<String> testSet = new HashSet<>();
        testSet.add("testOne");
        StopwordsDictionary dictionary = new StopwordsDictionary();
        dictionary.loadStopWords(Arrays.asList("testOne"));
        Assertions.assertEquals(testSet, dictionary.getStopWords());
    }

    @Test
    public void testLoadStopWordsNullList() {
        HashSet<String> testSet = new HashSet<>();
        StopwordsDictionary dictionary = new StopwordsDictionary();
        dictionary.loadStopWords(null);
        Assertions.assertEquals(testSet, dictionary.getStopWords());
    }

    @Test
    public void testLoadStopWordsEmptyList() {
        StopwordsDictionary dictionary = new StopwordsDictionary();
        dictionary.loadStopWords(Arrays.asList(""));
        HashSet<String> emptySet = dictionary.getStopWords();
        Assertions.assertEquals(0, emptySet.size());
    }

}
