package wordcount.operations;

import java.util.Arrays;

public class WordsCounter implements TextOperator {
    @Override
    public long operate(String text) {
        return Arrays.stream(text.split("[\\s]+"))
                .filter(word -> word.matches("[a-zA-Z]+"))
                .count();
    }
}
