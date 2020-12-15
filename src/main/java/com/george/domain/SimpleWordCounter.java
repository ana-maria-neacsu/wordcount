package com.george.domain;

import java.util.Arrays;

public class SimpleWordCounter implements WordCounter {

    public long count(String word) {
        return Arrays.stream(
                word.split(" "))
                .filter(s -> s.matches("[a-zA-Z]+"))
                .count();
    }
}
