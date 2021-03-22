package wordcount.interview;

import wordcount.interview.configuration.file.FileLinesCache;
import wordcount.interview.domain.counter.WordCounter;
import wordcount.interview.ui.input.ConsoleInput;
import wordcount.interview.ui.input.Input;
import wordcount.interview.ui.output.ConsoleOutput;
import wordcount.interview.ui.output.Output;

public class Application {
    private static final String STOP_WORD_FILE_PATH = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {
        Input input = new ConsoleInput(System.in);
        Output output = new ConsoleOutput(System.out);

        FileLinesCache fileLinesCache = new FileLinesCache(STOP_WORD_FILE_PATH);
        WordCounter wordCounter = new WordCounter(fileLinesCache.getLines());

        WordCount wordCount = new WordCount(input, output, wordCounter);
        wordCount.run();
    }
}
