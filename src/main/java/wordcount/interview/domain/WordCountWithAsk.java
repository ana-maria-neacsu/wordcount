package wordcount.interview.domain;

import wordcount.interview.ui.output.Output;

public class WordCountWithAsk implements WordCount {
    private static final String ENTER_TEXT = "Enter text:";
    private final Output output;
    private final WordCountDefault wordCountDefault;

    public WordCountWithAsk(Output output, WordCountDefault wordCountDefault) {
        this.output = output;
        this.wordCountDefault = wordCountDefault;
    }

    public void run() {
        output.write(ENTER_TEXT);
        wordCountDefault.run();
    }
}
