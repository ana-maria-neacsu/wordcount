package wordcount.interview.domain;

import wordcount.interview.domain.counter.WordCounter;
import wordcount.interview.ui.input.Input;
import wordcount.interview.ui.output.Output;

public class WordCountFactory {
    public static WordCount build(Input input, Output output, WordCounter wordCounter, WordCountType type) {
        WordCount wordCount = null;
        switch (type) {
            case DEFAULT:
                wordCount = new WordCountDefault(input, output, wordCounter);
                break;
            case WITH_ASK:
                WordCountDefault wordCountDefault = new WordCountDefault(input, output, wordCounter);
                wordCount = new WordCountWithAsk(output, wordCountDefault);
                break;
        }
        return wordCount;
    }
}
