package com.george.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordPreparator {

    private final String stopWords;

    public WordPreparator(String stopWords) {
        this.stopWords = stopWords;
    }

    public List<String> prepare(String word) {
        String[] splitBySpaces = word.split(" ");

        List<String> withoutDots = removeTrailingDots(Arrays.asList(splitBySpaces));

        return withoutDots.stream()
                .filter(s -> s.matches("[a-zA-Z\\-]+"))
                .filter(s -> !stopWords.contains(s))
                .collect(Collectors.toList());
    }

    private List<String> removeTrailingDots(List<String> word) {
        List<String> withoutDots = new ArrayList<>();
        for (String s : word) {
            if (s.endsWith("-") || s.startsWith("-")) continue;
            if (s.endsWith(".")) {
                s = s.substring(0, s.length() - 1);
            }
            withoutDots.add(s);
        }
        return withoutDots;
    }

}
