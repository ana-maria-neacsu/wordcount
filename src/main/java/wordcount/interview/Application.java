package wordcount.interview;

import wordcount.interview.domain.WordCount;
import wordcount.interview.domain.WordCountFactory;
import wordcount.interview.domain.WordCountType;
import wordcount.interview.domain.counter.WordCounter;
import wordcount.interview.environment.file.FileLinesReader;
import wordcount.interview.ui.input.ConsoleInput;
import wordcount.interview.ui.input.FileInput;
import wordcount.interview.ui.input.Input;
import wordcount.interview.ui.output.ConsoleOutput;
import wordcount.interview.ui.output.Output;

import static wordcount.interview.domain.WordCountType.DEFAULT;
import static wordcount.interview.domain.WordCountType.WITH_ASK;

public class Application {
    private static final String STOP_WORD_FILE_PATH = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {
        Output output = new ConsoleOutput(System.out);
        FileLinesReader fileLinesReader = new FileLinesReader();
        WordCounter wordCounter = new WordCounter(fileLinesReader.getLines(STOP_WORD_FILE_PATH));

        Input input;
        WordCountType type;

        if (args == null || args.length == 0) {
            input = new ConsoleInput(System.in);
            type = WITH_ASK;
        } else {
            String fileName = args[0];
            input = new FileInput(fileName, fileLinesReader);
            type = DEFAULT;
        }

        WordCount wordCount = WordCountFactory.build(input, output, wordCounter, type);
        wordCount.run();
    }
}
