package com.george.domain.consolebasedcounter;

import com.george.domain.WordCounter;

import java.util.Arrays;

public class SimpleWordCounter implements WordCounter {

    public long count(String word) {
        return Arrays.stream(
                word.split(" "))
                .filter(s -> s.matches("[a-zA-Z]+"))
                .count();
    }
}
