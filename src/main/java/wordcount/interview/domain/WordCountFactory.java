package wordcount.interview.domain;

import wordcount.interview.domain.counter.WordCounter;
import wordcount.interview.ui.input.Input;
import wordcount.interview.ui.output.Output;

public class WordCountFactory {
    public static WordCount build(Input input, Output output, WordCounter wordCounter, WordCountType type) {
        if(type == null){
            throw new IllegalArgumentException("WordCountType is mandatory");
        }

        switch (type) {
            case DEFAULT:
                return new WordCountDefault(input, output, wordCounter);
            case WITH_ASK:
                WordCountDefault wordCountDefault = new WordCountDefault(input, output, wordCounter);
                return new WordCountWithAsk(output, wordCountDefault);
            default:
                throw new IllegalArgumentException(String.format("This type [%s] is not supported", type));
        }
    }
}
