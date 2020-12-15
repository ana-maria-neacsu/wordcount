package com.george.domain.filebasedcounter;

import com.george.domain.CountResult;
import com.george.domain.WordCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordsConditionedWordCounter implements WordCounter {

    private final String stopWords;

    public StopWordsConditionedWordCounter(String stopWords) {
        this.stopWords = stopWords;
    }

    public CountResult count(String word) {

        List<String> preparedList = prepareWord(word);
        long wordsCount = preparedList.size();
        long uniqueWordsCount = new HashSet<>(preparedList).size();

        return new CountResult(wordsCount, uniqueWordsCount);

    }

    private List<String> prepareWord(String word) {
        String[] splitBySpaces = word.split(" ");

        List<String> splitByDashes = splitByDashes(splitBySpaces);
        List<String> withoutDots = removeTrailingDots(splitByDashes);

        return withoutDots.stream()
                .filter(s -> s.matches("[a-zA-Z]+"))
                .filter(s -> !stopWords.contains(s))
                .collect(Collectors.toList());
    }

    private List<String> removeTrailingDots(List<String> withoutDashes) {
        List<String> withoutDots = new ArrayList<>();
        for (String s : withoutDashes) {
            if (s.endsWith(".")) {
                s = s.substring(0, s.length() - 1);
            }
            withoutDots.add(s);
        }
        return withoutDots;
    }

    private List<String> splitByDashes(String[] splitBySpaces) {
        List<String> splitByDashes = new ArrayList<>();

        for (String s : splitBySpaces) {
            final String[] split = s.split("-");
            splitByDashes.addAll(Arrays.asList(split));
        }
        return splitByDashes;
    }
}

//1 - split by space " "
//2 - split again the ones have a dash
//3 - strip trailing dots