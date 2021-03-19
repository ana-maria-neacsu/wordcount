package wordcount;

import wordcount.input.ConsoleInputReader;
import wordcount.input.InputReader;
import wordcount.input.InputReaderFactory;
import wordcount.output.ConsoleOutputWriter;
import wordcount.output.OutputWriter;
import wordcount.service.StopWordsLoader;
import wordcount.service.WordsCounterService;

import static wordcount.output.OutputFormatter.numberOfWordsFormatter;

public class ApplicationRunner {

    public static void main(String[] args) {

        InputReader inputReader = InputReaderFactory.getInputReader(args);
        OutputWriter outputWriter = new ConsoleOutputWriter();
        if (inputReader instanceof ConsoleInputReader) {
            outputWriter.write("Enter text: ");
        }
        String input = inputReader.readInput();
        long count = new WordsCounterService(new StopWordsLoader()).countWords(input);
        outputWriter.write(numberOfWordsFormatter(count));

    }
}
