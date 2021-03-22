package wordcount.interview;

import wordcount.interview.domain.counter.WordCounter;
import wordcount.interview.ui.input.Input;
import wordcount.interview.ui.output.Output;

public class WordCount {
    private static final String NUMBER_OF_WORDS = "Number of words: ";
    private final Input input;
    private final Output output;
    private final WordCounter wordCounter;

    public WordCount(Input input, Output output, WordCounter wordCounter) {
        this.input = input;
        this.output = output;
        this.wordCounter = wordCounter;
    }

    public void run() {
        String inputText = input.read();
        long countedWord = wordCounter.count(inputText);
        output.write(NUMBER_OF_WORDS + countedWord);
    }
}
