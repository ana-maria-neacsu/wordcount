package wordcount.interview;

import wordcount.interview.domain.WordCounter;
import wordcount.interview.ui.input.ConsoleInput;
import wordcount.interview.ui.input.Input;
import wordcount.interview.ui.output.ConsoleOutput;
import wordcount.interview.ui.output.Output;

import java.util.Collections;

import static java.util.Collections.emptySet;

public class Application {
    public static void main(String[] args) {
        Input input = new ConsoleInput(System.in);
        Output output = new ConsoleOutput(System.out);
        WordCounter wordCounter = new WordCounter(emptySet());

        WordCount wordCount = new WordCount(input, output, wordCounter);
        wordCount.run();
    }
}
