package wordcount.interview;

import wordcount.interview.domain.counter.WordCounter;
import wordcount.interview.environment.file.FileLinesReader;
import wordcount.interview.ui.input.ConsoleInput;
import wordcount.interview.ui.input.Input;
import wordcount.interview.ui.output.ConsoleOutput;
import wordcount.interview.ui.output.Output;

public class Application {
    private static final String STOP_WORD_FILE_PATH = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            Input input = new ConsoleInput(System.in);
            Output output = new ConsoleOutput(System.out);

            FileLinesReader fileLinesReader = new FileLinesReader();
            WordCounter wordCounter = new WordCounter(fileLinesReader.getLines(STOP_WORD_FILE_PATH));

            WordCountWithAsk wordCount = new WordCountWithAsk(input, output, wordCounter);
            wordCount.run();
        }
    }
}
