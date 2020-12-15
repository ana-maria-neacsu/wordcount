package com.george.app;

import com.george.domain.InputReader;
import com.george.domain.WordCounter;
import com.george.domain.filebasedcounter.StopWordsConditionedWordCounter;

public class InputMethodSelector {

    private final InputReader reader;
    private final WordCounter counter;

    public InputMethodSelector(InputReader reader, String stopWords){
        this.reader = reader;
        counter = new StopWordsConditionedWordCounter(stopWords);
    }

    public long apply() {
        final String input = reader.read();
        return counter.count(input);
    }

}
