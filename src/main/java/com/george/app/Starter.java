package com.george.app;

import com.george.domain.filebasedcounter.FileConditionedWordCounter;
import com.george.ports.ConsoleInputReader;
import com.george.domain.consolebasedcounter.SimpleWordCounter;

public class Starter {

    public static void main(String[] args) {
        String input = new ConsoleInputReader().read();
        System.out.println(new SimpleWordCounter().count(input));

        System.out.println(new FileConditionedWordCounter("stopwords.txt").count(input));

    }
}
