package wordcount.interview;

import wordcount.interview.domain.counter.WordCounter;
import wordcount.interview.ui.input.Input;
import wordcount.interview.ui.output.Output;

public class WordCountWithAsk extends WordCount {
    private static final String ENTER_TEXT = "Enter text:";
    private final Output output;

    public WordCountWithAsk(Input input, Output output, WordCounter wordCounter) {
        super(input, output, wordCounter);
        this.output = output;
    }

    public void run() {
        output.write(ENTER_TEXT);
        super.run();
    }
}
