package com.wordcounter.test;

import com.wordcounter.StopWords.StopWords;
import com.wordcounter.StopWords.impl.StopWordsImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordsTests {

    @Test
    public void when_called_than_return_list() {
        StopWords stopWords = new StopWordsImpl();
        List<String> stopWordsNumber = stopWords.getStopWords();

        assertEquals(2, stopWordsNumber);
    }
}
